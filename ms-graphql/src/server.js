const fs = require('fs');
const path = require('path');
require('./config/config')

const {ApolloServer,gql} = require('apollo-server-express')
const {resolvers} = require('./resolvers/Index')
const { RedisPubSub } = require('graphql-redis-subscriptions')
const { SubscriptionServer } = require('subscriptions-transport-ws')
const express = require('express');
const http = require('http');

const {CustomerAPI}  = require('./datasources/CustomerApi')
const {AccountAPI}  = require('./datasources/AccountApi')


const pubsub = new RedisPubSub({
  connection: {
    host: process.env.REDIS_HOST,
    port: process.env.REDIS_PORT,
    password: process.env.REDIS_PASSWORD,
    retry_strategy: options => {
      return Math.max(options.attempt * 100, 3000);
    }
  }
});


const port = process.env.PORT
const app = express();
const typeDefs = gql(fs.readFileSync(path.resolve(__dirname, './schema.graphql'),{encoding:'utf-8'}));


const dataSources = () => ({
  customerAPI: new CustomerAPI(),
  accountAPI: new AccountAPI()
});

const context = (request) => {
  return {
    request,
    pubsub
  }
}


const apolloServer = new ApolloServer({typeDefs,resolvers,dataSources,context,
    subscriptions: {
      onConnect: () => console.log('Connected to websocket'),
    }
  });
apolloServer.applyMiddleware({app, path: '/graphql'});

const httpServer = http.createServer(app);
apolloServer.installSubscriptionHandlers(httpServer);
httpServer.listen(port, () => console.log(`Server started on port ${port}`));

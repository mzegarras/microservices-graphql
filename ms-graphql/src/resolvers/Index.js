'use strict';

const {Query} = require('./Query')
const {Mutation} = require('./Mutation')
const {Customer} = require('./Customer')
const {Account} = require('./Account')
const {Subscription} = require('./Subscription')

const resolvers = {
    Query,
    Mutation,
    Customer,
    Account,
    Subscription
}


module.exports = {
    resolvers
}

const MESSAGE_ADDED = 'CUSTOMER_ADDED';

const Mutation = {
    save:(parent,args,{request,pubsub},info)=> {
        return 'Hello world!';   
    },
    createCustomer:async(parent,args,{ request,dataSources,pubsub },info)=> {
    
        const response = await dataSources.customerAPI.save(args.data);
        pubsub.publish(MESSAGE_ADDED, {customerChanged: response});
        return response;

        

    }
}

module.exports = {
    Mutation
}

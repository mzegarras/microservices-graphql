const Subscription = {
    customerChanged:{
        subscribe(parent, args, {pubsub}, info){
            return pubsub.asyncIterator(['CUSTOMER_ADDED']);
        }
    }
}



module.exports = {
    Subscription
}
'use strict';


const Query = {
    me:(_,args,{ request,dataSources })=> {
    
        return {
            id:"12",
            name: "Manuel",
            lastName: "Zegarra"
        }
    },

    customers:async (parent,args,{request,dataSources},info)=> {
        return dataSources.customerAPI.list();
    },
    accounts:async (parent,args,{request,dataSources},info)=> {
        return dataSources.accountAPI.list(args.data);
    },
    transactions: async (parent,args,{request,dataSources},info)=> {
        return dataSources.accountAPI.listTransactions(args.data);
    }

}



module.exports = {
    Query
}


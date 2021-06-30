'use strict';

const Customer = {
     accounts:async (parent,args,{request,dataSources},info)=> {
        return dataSources.accountAPI.list(parent);
    }

}



module.exports = {
    Customer
}

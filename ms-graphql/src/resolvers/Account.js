'use strict';

const Account = {
    // owner:{
    //     fragment: 'fragment ownerId on Account { document {type number} }',
    //     resolve(parent,args,{request,dataSources},info){
    //         return dataSources.customerAPI.getById({documentType:parent.document.type,documentNumber:parent.document.number});

    //     }
    // }

    transactions:{
        fragment: 'fragment numberAccount on Account { number }',
        resolve(parent,args,{request,dataSources},info){            
            return dataSources.accountAPI.listTransactions({accountId:parent.number});
        }
    }

}



module.exports = {
    Account
}

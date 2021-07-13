'use strict';
require('../config/config')

const { RESTDataSource } = require('apollo-datasource-rest');

class AccountAPI extends RESTDataSource {
    constructor() {
      super();
      this.baseURL = process.env.URL_API_ACCOUNT;
    }
    
    async list({documentType,documentNumber}) {
      const response = await this.get(`accounts?type=${documentType}&number=${documentNumber}`);
      return Array.isArray(response) ? response.map(launch => this.transforAccount(launch)) : [];
    
    }

    async listTransactions({accountId}) {
      const response = await this.get(`accounts/${accountId}/transactions`);
      return Array.isArray(response) ? response.map(launch => this.transforTransaction(launch)) : [];
    }


    transforAccount(account) { 
      return {
        id: account.id,
        number: account.number,
        currency: account.currency,
        amount: account.amount,
        avatar: account.avatar,
        document: {
          type: account.document.documentType,
          number: account.document.documentNumber
        }
      }
    }


    transforTransaction(transaction) { 
      return {
        id: transaction.id,
        type: transaction.type,
        description: transaction.description,
        createAt: transaction.date,
        currency: transaction.currency,
        amount: transaction.amount
      }
    }

  }

  module.exports = {
    AccountAPI
  }
  
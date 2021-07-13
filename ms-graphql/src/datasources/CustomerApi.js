'use strict';
require('../config/config')

const { RESTDataSource } = require('apollo-datasource-rest');

class CustomerAPI extends RESTDataSource {
  
    constructor() {
      super();
      this.baseURL = process.env.URL_API_CUSTOMER;
    }
  
    async list() {
        const response = await this.get(`customers`);
        return Array.isArray(response) ? response.map(launch => this.launchReducer(launch)) : [];
    }

    async getById({documentType,documentNumber}) {
      
      const response = await this.get(`customers/${documentType}/${documentNumber}`);
      return this.launchReducer(response);
    }

    async save({name,lastName,documentType,createAt,documentNumber}) {
      const response = await  this.post(
        `customers`,
        {
          firstName: name,
          lastName,
          createAt,
          documentType,
          documentNumber
        }
      );


      return this.launchReducer(response);
  }

    launchReducer(customer) { 
      return {
        id: customer.id,
        name: customer.firstName,
        lastName: customer.lastName,
        documentType: customer.documentType,
        documentNumber: customer.documentNumber,
        adress: customer.adress,
        avatar: customer.avatar
      }
    }
  }
module.exports = {
  CustomerAPI
}
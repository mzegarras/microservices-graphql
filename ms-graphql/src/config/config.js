

process.env.PORT = process.env.PORT || 3000;
process.env.NODE_ENV = process.env.NODE_ENV || 'dev';

process.env.URL_API_ACCOUNT = process.env.URL_API_ACCOUNT||'http://localhost:8082/';
process.env.URL_API_CUSTOMER = process.env.URL_API_CUSTOMER||'http://localhost:8081/';


process.env.REDIS_HOST = process.env.REDIS_HOST||'localhost';
process.env.REDIS_PORT = process.env.REDIS_PORT||6379;
process.env.REDIS_PASSWORD = process.env.REDIS_PASSWORD||'password';
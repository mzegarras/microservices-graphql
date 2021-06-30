
# Stage 0, "build-stage"

FROM node:12-alpine

# Create app directory
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install

ADD ./src ./
EXPOSE 3000

ENTRYPOINT [ "npm", "start" ]
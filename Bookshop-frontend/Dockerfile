FROM node:18.16.0

WORKDIR /app

COPY package.json ./

RUN npm install -g @angular/cli@16.1.0 && npm install

COPY . .

RUN npm run build

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]
FROM node:latest as build
WORKDIR /user/local/app
COPY ./ /user/local/app
RUN npm install
RUN npm run build

FROM nginx:latest
COPY --from=build /user/local/app/dist/front-end/browser /usr/share/nginx/html
EXPOSE 80

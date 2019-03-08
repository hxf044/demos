import Vue from 'vue'
import App from './App'
import router from './router'
// import VueSocketio from 'vue-socket.io'
// import socketio from 'socket.io-client'
// import store from './yourstore'
Vue.config.productionTip = false

/* eslint-disable no-new */
// Vue.use(VueSocketio,socketio('http://socketserver.com:1923'), store)
// Vue.use(VueSocketio,socketio('http://127.0.0.1:8089/socketServer/test1'))
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})

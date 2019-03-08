import Vue from 'vue'
import Router from 'vue-router'
import MessageReceive from '@/components/MessageReceive'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MessageReceive',
      component: MessageReceive
    }
  ]
})

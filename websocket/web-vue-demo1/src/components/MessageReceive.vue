<template>
  <div>
    <div v-for="(item,index) in date" :key='index'>
        <p>{{item}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MessageReceive',
  data(){
      return{
          id:'',
          ws: null,
          wsUrl: 'ws://127.0.0.1:8080/socketServer/test1',
          connectMsg: '',
          emitData: 'socketServer/test1',
          date: []
      }
  },
  mounted(){
     this.initSocket();
  },
  /*sockets:{
    connect: function(){  //这里是监听connect事件
      this.id=this.$socket.id
    },
    customEmit: function(val){
      console.log(val)
    }
  },*/
  methods: {
      initSocket(){
        if ('WebSocket' in window){
          this.ws = new WebSocket(this.wsUrl);
        } else if ('MozWebSocket' in window){
          this.ws = new MozWebSocket(this.wsUrl);
        }else{
          alert("该浏览器不支持websocket");    
        } 
        this.ws.onerror = this.websocketOnError
        this.ws.onmessage = this.websocketOnMessage
        this.ws.onclose = this.websocketOnClose  
      },
       //连接发生错误的回调方法
      websocketOnError() {
        console.log("WebSocket 连接发生错误")
      },
      //接收到消息的回调方法
      websocketOnMessage(event) {
        // 接收消息
        console.log(event.data)
        this.date.push(event.data)
      },
      //连接关闭的回调方法
      websocketOnClose(e) {
        console.log("WebSocket 连接关闭", e)
        console.log(this.ws)
      },
      //关闭 WebSocket 连接
      websocketClose() {
         this.ws.close()
      },
  }

}
</script>

<style scoped>

</style>

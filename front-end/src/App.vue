<template>
  <!-- 标题 -->
  <h1>营业厅管理系统</h1>
  <hr>

  <!-- 地区选择下拉框 -->
  <div style="display:inline-block">
    <selectBox title="选择地区" :options="area" @valueChange="setOffice"></selectBox>
  </div>
  
  <!-- 日期选择器 -->
  <div style="display:inline-block">
    <datePicker title="选择日期" @dateChange="setDate"></datePicker>
  </div>

  <!-- 查询按钮 -->
  <el-button type="success" round @click="reQuery">查询</el-button>
  
  <!-- 显示营业厅数据的表格 -->
  <officeTable :officeData="office" :workTimeData="workTime"></officeTable>
</template>

<script>
import selectBox from './components/selectBox.vue'
import officeTable from './components/officeTable.vue'
import datePicker from './components/datePicker.vue'
import axios from 'axios'
import qs from 'qs'

export default {
  name: 'App',
  components: {
    selectBox,     // 地区选择下拉框组件
    datePicker,    // 日期选择器组件
    officeTable    // 营业厅数据表格组件
  },
  data() {
    return {
      area: [],       // 存储地区数据
      office: [],     // 存储营业厅数据
      date: [],       // 存储选择的日期
      workTime: []    // 存储工作时间数据
    }
  },
  methods: {
    // 根据选择的地区获取对应的营业厅数据
    setOffice(value){
      axios.get(`http://localhost:8088/office?value=${value}`).then((response)=>{
        this.office=response.data
      })
    },
    // 设置选择的日期
    setDate(value){
      this.date=value
    },
    // 查询工作时间数据
    reQuery(){
      let officeId=[]
      this.office.forEach(e => {
          officeId.push(e.id)
      })
      axios.post("http://localhost:8088/workTime",qs.stringify(
        {officeId: officeId},{indices: false})).then(
          axios.get("http://localhost:8088/workTime",
            {params: {
              date: this.date,
            }}).then((response)=>{
              this.workTime=response.data
            })
        )
    }
  },
  // 在组件创建时获取地区和营业厅数据
  created: function(){
    axios.get("http://localhost:8088/area").then((response)=>{
      this.area=response.data
    })
    axios.get(`http://localhost:8088/office`).then((response)=>{
      this.office=response.data
    })
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}
</style>

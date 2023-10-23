<template>
  <!-- 主内容区域 -->
  <div class="main">
    <!-- 数据表格 -->
    <el-table :data="tableData" height="750" style="width:100%;" stripe>
        <!-- 各个列定义 -->
        <el-table-column prop="id" label="编号" width="180" />
        <el-table-column prop="name" label="机构名称" width="360" />
        <el-table-column prop="state" label="营业状态" width="180" />
        <el-table-column prop="date" label="日期" width="180" />
        <el-table-column prop="openTime" label="营业开始时间" width="180" />
        <el-table-column prop="closeTime" label="营业结束时间" width="180" />

        <!-- 操作列，用于编辑数据 -->
        <el-table-column label="操作">
            <template #default="scope">
            <el-button size=small type="primary" round @click="dialogPopUp(scope.row)">
                编辑
            </el-button>
            </template>
        </el-table-column>
    </el-table>

    <!-- 数据编辑弹窗组件 -->
    <info-editor :clicks="clicks" :info="rowData"></info-editor>
  </div>
</template>

<script>
import infoEditor from './infoEditor.vue'
    export default {
        data(){
            return{
                clicks: 0,        // 点击计数
                rowData: [],      // 存储选中行的数据
                tableData: []     // 表格展示数据
            }
        },
        components: {
            infoEditor        // 导入数据编辑弹窗组件
        },
        methods:{
            // 合并机构和工作时间数据
            getTableData(officeData,workTimeData){
                this.tableData=[]
                for(var i=0;i<officeData.length;i++){
                    this.tableData.push(Object.assign(officeData[i],workTimeData[i]))
                }
            },
            // 弹出数据编辑窗口
            dialogPopUp(row){
                this.clicks=this.clicks+1;
                this.rowData=row
            }
        },
        props: {
            // 从父组件传入的机构数据
            officeData: {
                type: Array,
                default(){
                    return [];
                }
            },
            // 从父组件传入的工作时间数据
            workTimeData: {
                type: Array,
                default(){
                    return [];
                }
            }
        },
        watch: {
            // 监听工作时间数据变化，合并数据
            workTimeData: {
                handler(newData){
                    this.getTableData(this.officeData,newData)
                },
                deep: true
            },
        }
    }
</script>

<style>
    .main{
      margin:0 auto;
      text-align: center;
    }
</style>
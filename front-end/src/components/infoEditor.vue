<template>
  <!-- 主弹窗组件，用于管理营业时间 -->
  <el-dialog v-model="dialogFormVisible" title="营业时间管理">
    <!-- 输入表单区 -->
    <el-form :model="form">
      <!-- 显示日期 -->
      <el-form-item label="日期" :label-width="formLabelWidth">
        {{info.date}}
      </el-form-item>
      <!-- 显示营业厅名称 -->
      <el-form-item label="营业厅名称" :label-width="formLabelWidth">
        {{info.name}}
      </el-form-item>
      <!-- 下拉框选择营业状态：营业或休息 -->
      <el-form-item label="营业状态" :label-width="formLabelWidth">
        <el-select v-model="state" placeholder="设定营业状态">
          <el-option label="营业" value=true />
          <el-option label="休息" value=false />
        </el-select>
      </el-form-item>
      <!-- 下拉框选择营业开始时间 -->
      <el-form-item label="营业开始时间" :label-width="formLabelWidth">
        <el-select v-model="openTime" placeholder="选择营业开始时间">
          <el-option label="08:00:00" value="08:00:00" />
          <el-option label="09:00:00" value="09:00:00" />
          <el-option label="10:00:00" value="10:00:00" />
          <el-option label="11:00:00" value="11:00:00" />
        </el-select>
      </el-form-item>
      <!-- 下拉框选择营业结束时间 -->
      <el-form-item label="营业结束时间" :label-width="formLabelWidth">
        <el-select v-model="closeTime" placeholder="选择营业结束时间">
          <el-option label="15:00:00" value="15:00:00" />
          <el-option label="16:00:00" value="16:00:00" />
          <el-option label="17:00:00" value="17:00:00" />
          <el-option label="18:00:00" value="18:00:00" />
        </el-select>
      </el-form-item>
    </el-form>
    <!-- 弹窗底部的按钮区：包含取消和确认按钮 -->
    <template #footer>
      <span class="dialog-footer">
        <!-- 点击取消按钮，关闭弹窗 -->
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <!-- 点击确认按钮，触发编辑函数并关闭弹窗 -->
        <el-button type="primary" @click="dialogFormVisible = false,edit()">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
  import axios from 'axios'  // 引入axios库，用于前后端交互
  import qs from 'qs'        // 引入qs库，用于处理HTTP请求中的查询字符串

  export default {
    data() {
      return {
        dialogFormVisible: false,   // 控制弹窗的显示状态
        state: undefined,          // 营业状态
        openTime: undefined,       // 营业开始时间
        closeTime: undefined,      // 营业结束时间
        data: {                    // 待发送到后端的数据
          date: undefined,
          office: undefined,
          state: true,
          openTime: "08:00:00",
          closeTime: "17:00:00"
        },
        formLabelWidth: '120px'    // 表单标签的宽度
      };
    },
    methods: {
      // 编辑方法：将用户输入的数据发送到后端
      edit(){
        // 设置待发送数据的值
        this.data.date = this.info.date;
        this.data.office = this.info.id;
        this.data.openTime = this.openTime;
        this.data.closeTime = this.closeTime;
        // 打印数据（调试用）
        console.log(this.data);
        // 使用axios发送post请求到后端
        axios.post("http://localhost:8088/workTime/set", qs.stringify(this.data));
      }
    },
    props: {
       clicks: Number,    // 用于触发弹窗显示的属性
       info: Array       // 存储从父组件传入的营业厅信息
    },
    watch: {
      // 监听clicks属性，当其值发生变化时显示弹窗
      clicks() {
        this.dialogFormVisible = true;
      }
    }
  };
</script>

<style scoped>
  /* 设置文本按钮的右边距 */
  .el-button--text {
    margin-right: 15px;
  }
  /* 设置下拉选择框的宽度 */
  .el-select {
    width: 300px;
  }
  /* 设置输入框的宽度 */
  .el-input {
    width: 300px;
  }
  /* 设置底部按钮的间距 */
  .dialog-footer button:first-child {
    margin-right: 10px;
  }
</style>
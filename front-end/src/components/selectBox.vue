<template>
  <!-- 标题显示 -->
  <span>{{title}}</span>
  
  <!-- 下拉选择框，当选择项改变时触发 valueChange 事件 -->
  <el-select v-model="value" clearable placeholder="请选择" @change="$emit('valueChange',$event)">
    <!-- 循环生成下拉选项 -->
    <el-option
      v-for="item in options"
      :key="item.id"
      :label="item.name"
      :value="item.id">
    </el-option>
  </el-select>
</template>

<script>
  export default {
    data() {
      return {
        value: ''  // 存储当前选中的值
      }
    },
    props: {
      title: String,  // 标题
      options: {      // 下拉选项数据
        type: Array,
        default(){
          return []
        }
      }
    },
  }
</script>
<template>
  <div class="block">
    <!-- 显示标题 -->
    <span class="demonstration">{{title}}</span>
    <!-- 日期选择器 -->
    <el-date-picker
      v-model="value"         
      type="date"         
      placeholder="选择日期"
      format="YYYY 年 MM 月 DD 日"
      value-format="YYYY-MM-DD"
      :picker-options="pickerOptions"
      @change="$emit('dateChange',$event)">
    </el-date-picker>
  </div>
</template>

<script>
  export default {
    props: ['title'],  // 父组件传来的标题

    data() {
      return {
        pickerOptions: {  // 选择器选项
          // 禁用未来一周内的日期和过去24小时内的日期
          disabledDate(time) {
            return time.getTime() > Date.now() + 3600 * 1000 * 24 * 7
                || time.getTime() < Date.now() - 3600 * 1000 * 24;
          }
        },
        value: '',  // 选择的日期值
      };
    }
  };
</script>
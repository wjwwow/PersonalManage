(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3baf6b54"],{"8d41":function(e,t,i){},"9b5f":function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container"},[i("div",{staticClass:"filter-container"},[i("el-checkbox",{staticClass:"filter-item",staticStyle:{"margin-left":"63%","margin-bottom":"20px"},on:{change:function(t){e.tableKey=e.tableKey+1}},model:{value:e.showReviewer,callback:function(t){e.showReviewer=t},expression:"showReviewer"}},[e._v(" 重要性 ")]),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"400px"},attrs:{type:"primary",icon:"el-icon-edit"},on:{click:e.handleCreate}},[e._v(" 添加计划 ")])],1),i("el-table",{attrs:{data:e.list,border:"",fit:"","highlight-current-row":""}},[i("el-table-column",{attrs:{align:"center",label:"序号",width:"95"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.$index+1)+" ")]}}])}),i("el-table-column",{attrs:{label:"计划内容"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.row.content)+" ")]}}])}),e.showReviewer?i("el-table-column",{attrs:{label:"重要性",width:"80px"},scopedSlots:e._u([{key:"default",fn:function(t){return e._l(+t.row.imp,(function(e){return i("svg-icon",{key:e,staticClass:"meta-item__icon",attrs:{"icon-class":"star"}})}))}}],null,!1,1159874743)}):e._e(),i("el-table-column",{attrs:{label:"状态","class-name":"status-col",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.endTime<new Date?i("div",{staticClass:"cell"},[i("span",{staticClass:"el-tag el-tag--danger el-tag--medium"},[e._v("逾期")])]):e._e()]}}])}),i("el-table-column",{attrs:{align:"center",prop:"created_at",label:"结束时间",width:"200"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("i",{staticClass:"el-icon-time"}),i("span",[e._v(e._s(e._f("parseTime")(t.row.endTime,"{y}-{m}-{d} {h}:{i}")))])]}}])}),i("el-table-column",{attrs:{label:"Actions",align:"center",width:"230","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(i){return e.handleUpdate(t.row)}}},[e._v(" 编辑 ")]),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){return e.handleDelete(t.$index,t.row)}}},[e._v(" 完成 ")])]}}])})],1),i("el-dialog",{attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[i("el-form",{ref:"dataForm",staticStyle:{width:"400px","margin-left":"50px"},attrs:{rules:e.rules,model:e.temp,"label-position":"left","label-width":"80px"}},[i("el-form-item",{attrs:{label:"计划内容",prop:"content"}},[i("el-input",{model:{value:e.temp.content,callback:function(t){e.$set(e.temp,"content",t)},expression:"temp.content"}})],1),i("el-form-item",{attrs:{label:"重要性"}},[i("el-rate",{staticStyle:{"margin-top":"8px"},attrs:{colors:["#99A9BF","#F7BA2A","#FF9900"],max:3},model:{value:e.temp.imp,callback:function(t){e.$set(e.temp,"imp",t)},expression:"temp.imp"}})],1),i("el-form-item",{staticStyle:{width:"100px"},attrs:{label:"结束时间",prop:"endTime"}},[i("el-date-picker",{attrs:{type:"datetime",placeholder:"Please pick a date"},model:{value:e.temp.endTime,callback:function(t){e.$set(e.temp,"endTime",t)},expression:"temp.endTime"}})],1)],1),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v(" 取消 ")]),i("el-button",{attrs:{type:"primary"},on:{click:function(t){"create"===e.dialogStatus?e.createData():e.updateData()}}},[e._v(" 确定 ")])],1)],1),i("el-dialog",{attrs:{visible:e.dialogPvVisible,title:"Reading statistics"},on:{"update:visible":function(t){e.dialogPvVisible=t}}},[i("el-table",{staticStyle:{width:"100%"},attrs:{data:e.pvData,border:"",fit:"","highlight-current-row":""}},[i("el-table-column",{attrs:{prop:"key",label:"Channel"}}),i("el-table-column",{attrs:{prop:"pv",label:"Pv"}})],1),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogPvVisible=!1}}},[e._v("Confirm")])],1)],1)],1)},n=[],l=i("5530"),s=(i("b0c0"),i("a434"),i("c740"),i("ed08")),o=i("2f62"),r=(i("8d41"),"@@wavesContext");function c(e,t){function i(i){var a=Object.assign({},t.value),n=Object.assign({ele:e,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),l=n.ele;if(l){l.style.position="relative",l.style.overflow="hidden";var s=l.getBoundingClientRect(),o=l.querySelector(".waves-ripple");switch(o?o.className="waves-ripple":(o=document.createElement("span"),o.className="waves-ripple",o.style.height=o.style.width=Math.max(s.width,s.height)+"px",l.appendChild(o)),n.type){case"center":o.style.top=s.height/2-o.offsetHeight/2+"px",o.style.left=s.width/2-o.offsetWidth/2+"px";break;default:o.style.top=(i.pageY-s.top-o.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",o.style.left=(i.pageX-s.left-o.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return o.style.backgroundColor=n.color,o.className="waves-ripple z-active",!1}}return e[r]?e[r].removeHandle=i:e[r]={removeHandle:i},i}var d={bind:function(e,t){e.addEventListener("click",c(e,t),!1)},update:function(e,t){e.removeEventListener("click",e[r].removeHandle,!1),e.addEventListener("click",c(e,t),!1)},unbind:function(e){e.removeEventListener("click",e[r].removeHandle,!1),e[r]=null,delete e[r]}},u=function(e){e.directive("waves",d)};window.Vue&&(window.waves=d,Vue.use(u)),d.install=u;var m=d,p=i("333d"),f={components:{Pagination:p["a"]},directives:{waves:m},data:function(){return{showReviewer:!1,list:null,statusOptions:["published","draft","deleted"],temp:{id:"",endTime:new Date,content:"",username:this.name,imp:""},importanceOptions:[1,2,3],dialogFormVisible:!1,dialogStatus:"",textMap:{update:"Edit",create:"Create"},dialogPvVisible:!1,pvData:[],rules:{endTime:[{type:"date",required:!0,message:"请指定结束时间",trigger:"change"}],content:[{required:!0,message:"请输入计划内容",trigger:"blur"}]}}},computed:Object(l["a"])({},Object(o["b"])(["name"])),created:function(){this.fetchData()},filters:{parseTime:s["a"]},methods:{fetchData:function(){var e=this;this.axios({Method:"get",url:"http://10.11.2.5:8080/vue-admin-template/plan/"+this.name}).then((function(t){console.log(t.data),e.list=t.data}))},editPlan:function(e){this.$router.push("/editPlan/index/"+e)},handleUpdate:function(e){var t=this;this.temp=Object.assign({},e),this.temp.endTime=+new Date(this.temp.endTime),this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick((function(){t.$refs["dataForm"].clearValidate()}))},handleCreate:function(){var e=this;this.resetTemp(),this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick((function(){e.$refs["dataForm"].clearValidate()}))},handleDelete:function(e,t){var i=this;this.$confirm("你确认要完成此计划吗?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){i.axios({method:"GET",url:"http://10.11.2.5:8080/vue-admin-template/delete/"+t.id}).then((function(){i.list.splice(e,1),i.$message({type:"success",message:"完成计划!"})}))})).catch((function(){i.$message({type:"info",message:"已取消操作"})}))},resetTemp:function(){this.temp={id:Math.floor(1e6*Math.random()),content:"",endTime:new Date,username:this.name,imp:1}},createData:function(){var e=this;this.$refs["dataForm"].validate((function(t){t&&e.axios({method:"POST",url:"http://10.11.2.5:8080/vue-admin-template/createPlan/",data:e.temp}).then((function(){e.list.unshift(e.temp),e.dialogFormVisible=!1,e.$notify({title:"Success",message:"创建成功",type:"success",duration:2e3})}))}))},updateData:function(){var e=this;this.$refs["dataForm"].validate((function(t){if(t){var i=Object.assign({},e.temp);i.endTime=+new Date(i.endTime),e.axios({method:"POST",url:"http://10.11.2.5:8080/vue-admin-template/updatePlan/",data:i}).then((function(){var t=e.list.findIndex((function(t){return t.id===e.temp.id}));e.list.splice(t,1,e.temp),e.dialogFormVisible=!1,e.$notify({title:"Success",message:"修改成功",type:"success",duration:2e3})}))}}))}}},h=f,v=i("2877"),b=Object(v["a"])(h,a,n,!1,null,null,null);t["default"]=b.exports},c740:function(e,t,i){"use strict";var a=i("23e7"),n=i("b727").findIndex,l=i("44d2"),s=i("ae40"),o="findIndex",r=!0,c=s(o);o in[]&&Array(1)[o]((function(){r=!1})),a({target:"Array",proto:!0,forced:r||!c},{findIndex:function(e){return n(this,e,arguments.length>1?arguments[1]:void 0)}}),l(o)}}]);
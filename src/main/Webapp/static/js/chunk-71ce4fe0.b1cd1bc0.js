(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-71ce4fe0"],{3905:function(e,r,t){},4565:function(e,r,t){"use strict";t("6bec")},"6bec":function(e,r,t){},d5c2:function(e,r,t){"use strict";t.r(r);var a=function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"register-container"},[t("el-form",{ref:"ruleForm",staticClass:"register-form",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"120px","auto-complete":"on","label-position":"left"}},[t("div",{staticClass:"title-container"},[t("h3",{staticClass:"title"},[e._v("注册")])]),t("div",{staticClass:"title-container",staticStyle:{color:"white"}},[e._v("已有账号？"),t("router-link",{attrs:{to:"/login"}},[t("span",{staticStyle:{color:"red"}},[e._v("前往登入")])])],1),t("el-form-item",{attrs:{label:"用户名",prop:"username"}},[t("el-input",{attrs:{placeholder:"请输入用户名",type:"text",tabindex:"1","auto-complete":"on"},model:{value:e.ruleForm.username,callback:function(r){e.$set(e.ruleForm,"username",r)},expression:"ruleForm.username"}})],1),t("el-form-item",{attrs:{label:"密码",prop:"password"}},[t("el-input",{attrs:{type:"password",placeholder:"请输入密码",tabindex:"2","auto-complete":"on"},model:{value:e.ruleForm.password,callback:function(r){e.$set(e.ruleForm,"password",r)},expression:"ruleForm.password"}})],1),t("el-form-item",{attrs:{label:"确认密码",prop:"repassword"}},[t("el-input",{attrs:{type:"password",placeholder:"请输入确认密码",tabindex:"3","auto-complete":"on"},model:{value:e.ruleForm.repassword,callback:function(r){e.$set(e.ruleForm,"repassword",r)},expression:"ruleForm.repassword"}})],1),t("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[t("el-input",{attrs:{placeholder:"请输入邮箱",tabindex:"4","auto-complete":"on"},model:{value:e.ruleForm.email,callback:function(r){e.$set(e.ruleForm,"email",r)},expression:"ruleForm.email"}})],1),t("el-form-item",{attrs:{label:"验证码",prop:"code"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{placeholder:"请输入验证码",tabindex:"5","auto-complete":"on"},model:{value:e.ruleForm.code,callback:function(r){e.$set(e.ruleForm,"code",r)},expression:"ruleForm.code"}}),t("span",{staticStyle:{display:"inline-block",width:"150px",height:"40px",border:"1px solid #D7D7D7","margin-left":"25px"},on:{click:function(r){return e.changeImgCode()}}},[t("img",{staticStyle:{width:"100%",height:"100%",cursor:"pointer"},attrs:{src:e.imgCode}})])],1),t("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{type:"primary"},on:{click:function(r){return e.submitForm("ruleForm")}}},[e._v("注册")])],1)],1)},s=[],o=t("1da1"),i=(t("96cf"),t("ac1f"),t("00b4"),{name:"register",data:function(){var e=this,r=function(r,t,a){t!==e.ruleForm.password?a(new Error("两次输入密码不一致!")):a()},t=function(e,r,t){var a=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;setTimeout((function(){a.test(r)?t():t(new Error("请输入正确的邮箱格式"))}),100)},a=function(r,t,a){""!==t&&e.usernameRules().then((function(e){e?a(new Error("用户名已存在")):a()}))};return{ruleForm:{username:"",password:"",repassword:"",email:"",code:""},imgCode:"http://10.11.2.511:8080/vue-admin-template/kaptcha/1",rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"},{min:3,max:8,message:"用户名的长度为3到8个字符串",trigger:"blur"},{validator:a,message:"用户名已存在",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:5,max:16,message:"密码的长度为5到16个字符串",trigger:"blur"}],repassword:[{required:!0,message:"请输入确认密码",trigger:"blur"},{validator:r,message:"两次输入的密码不一致",trigger:"blur"}],email:[{required:!0,message:"请输入邮箱",trigger:"blur"},{validator:t,message:"邮箱的格式不正确",trigger:"blur"}],code:[{required:!0,message:"请输入验证码",trigger:"blur"}]}}},methods:{submitForm:function(e){var r=this;this.$refs[e].validate((function(e){if(!e)return!1;r.foo()}))},foo:function(){var e=this;this.axios({method:"POST",url:"http://10.11.2.511:8080/vue-admin-template/register",data:{username:this.ruleForm.username,password:this.ruleForm.password,email:this.ruleForm.email,code:this.ruleForm.code}}).then((function(r){"success"===r.data?(e.$message({message:"注册成功",type:"success"}),e.$router.push("/login")):"验证码错误"===r.data?e.$message.error("验证码错误"):"error"===r.data&&e.$message.error("注册失败")}))},usernameRules:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function r(){var t,a;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return r.next=2,e.axios.get("http://46o2352s89.zicp.vip/vue-admin-template/checkUserName/"+e.ruleForm.username);case 2:return t=r.sent,a=t.data,r.abrupt("return","exist"===a);case 5:case"end":return r.stop()}}),r)})))()},changeImgCode:function(){var e=Math.ceil(10*Math.random());this.imgCode="http://10.11.2.511:8080/vue-admin-template/kaptcha/"+e}}}),l=i,n=(t("4565"),t("fb96"),t("2877")),u=Object(n["a"])(l,a,s,!1,null,"60ee297c",null);r["default"]=u.exports},fb96:function(e,r,t){"use strict";t("3905")}}]);
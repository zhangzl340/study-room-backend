# 自习室预约系统 API


**简介**:自习室预约系统 API


**HOST**:http://localhost:8080/api


**联系人**:开发团队


**Version**:1.0.0


**接口路径**:/api/v3/api-docs


[TOC]






# 测试接口


## 获取所有枚举列表


**接口地址**:`/api/test/enums`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 测试枚举JSON序列化


**接口地址**:`/api/test/test-enum-body`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "userStatus": "",
  "userRole": "",
  "seatStatus": "",
  "otherField": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|testEnumRequest|TestEnumRequest|body|true|TestEnumRequest|TestEnumRequest|
|&emsp;&emsp;userStatus|可用值:DISABLED,NORMAL,LOCKED,PENDING||false|string||
|&emsp;&emsp;userRole|可用值:STUDENT,ADMIN,SUPER_ADMIN||false|string||
|&emsp;&emsp;seatStatus|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE||false|string||
|&emsp;&emsp;otherField|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultTestEnumRequest|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||TestEnumRequest|TestEnumRequest|
|&emsp;&emsp;userStatus|可用值:DISABLED,NORMAL,LOCKED,PENDING|string||
|&emsp;&emsp;userRole|可用值:STUDENT,ADMIN,SUPER_ADMIN|string||
|&emsp;&emsp;seatStatus|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|string||
|&emsp;&emsp;otherField||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"userStatus": "",
		"userRole": "",
		"seatStatus": "",
		"otherField": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 测试枚举实例方法


**接口地址**:`/api/test/test-enum-instance`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 测试枚举参数接收（支持多种格式）


**接口地址**:`/api/test/test-enum-param`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userStatus|可用值:DISABLED,NORMAL,LOCKED,PENDING|query|false|string||
|userRole|可用值:STUDENT,ADMIN,SUPER_ADMIN|query|false|string||
|seatStatus|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|query|false|string||
|testType||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 公告管理接口


## 创建公告


**接口地址**:`/api/api/admin/announcements/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "title": "",
  "content": "",
  "type": "",
  "isActive": true
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|announcementCreateRequest|AnnouncementCreateRequest|body|true|AnnouncementCreateRequest|AnnouncementCreateRequest|
|&emsp;&emsp;title|||false|string||
|&emsp;&emsp;content|||false|string||
|&emsp;&emsp;type|||false|string||
|&emsp;&emsp;isActive|||false|boolean||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 删除公告


**接口地址**:`/api/api/admin/announcements/delete/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取公告详情


**接口地址**:`/api/api/admin/announcements/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultAnnouncementVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||AnnouncementVO|AnnouncementVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;title||string||
|&emsp;&emsp;content||string||
|&emsp;&emsp;type||string||
|&emsp;&emsp;isActive||boolean||
|&emsp;&emsp;publishTime||string(date-time)||
|&emsp;&emsp;publisher||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"title": "",
		"content": "",
		"type": "",
		"isActive": true,
		"publishTime": "",
		"publisher": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取公告列表


**接口地址**:`/api/api/admin/announcements/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page||query|false|integer(int32)||
|pageSize||query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListAnnouncementVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|AnnouncementVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;title||string||
|&emsp;&emsp;content||string||
|&emsp;&emsp;type||string||
|&emsp;&emsp;isActive||boolean||
|&emsp;&emsp;publishTime||string(date-time)||
|&emsp;&emsp;publisher||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"title": "",
			"content": "",
			"type": "",
			"isActive": true,
			"publishTime": "",
			"publisher": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新公告状态


**接口地址**:`/api/api/admin/announcements/status/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|isActive||query|true|boolean||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新公告


**接口地址**:`/api/api/admin/announcements/update/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "title": "",
  "content": "",
  "type": "",
  "isActive": true
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|announcementCreateRequest|AnnouncementCreateRequest|body|true|AnnouncementCreateRequest|AnnouncementCreateRequest|
|&emsp;&emsp;title|||false|string||
|&emsp;&emsp;content|||false|string||
|&emsp;&emsp;type|||false|string||
|&emsp;&emsp;isActive|||false|boolean||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 管理端用户接口


## 调整用户信用分


**接口地址**:`/api/api/admin/user/adjust-credit/{id}`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|amount||query|true|integer(int32)||
|reason||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserVO|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"gender": 0,
		"college": "",
		"grade": "",
		"className": "",
		"identityStatus": 0,
		"lastLoginIp": "",
		"major": "",
		"studentId": "",
		"role": "",
		"status": 0,
		"creditScore": 0,
		"roleType": "",
		"createTime": "",
		"lastLoginTime": "",
		"createdAt": "",
		"updatedAt": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 创建用户


**接口地址**:`/api/api/admin/user/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "username": "",
  "password": "",
  "name": "",
  "email": "",
  "phone": "",
  "college": "",
  "major": "",
  "studentId": "",
  "role": "",
  "creditScore": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userCreateRequest|UserCreateRequest|body|true|UserCreateRequest|UserCreateRequest|
|&emsp;&emsp;username|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;college|||false|string||
|&emsp;&emsp;major|||false|string||
|&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;role|||false|string||
|&emsp;&emsp;creditScore|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserVO|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"gender": 0,
		"college": "",
		"grade": "",
		"className": "",
		"identityStatus": 0,
		"lastLoginIp": "",
		"major": "",
		"studentId": "",
		"role": "",
		"status": 0,
		"creditScore": 0,
		"roleType": "",
		"createTime": "",
		"lastLoginTime": "",
		"createdAt": "",
		"updatedAt": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 删除用户


**接口地址**:`/api/api/admin/user/delete/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户详情


**接口地址**:`/api/api/admin/user/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserVO|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"gender": 0,
		"college": "",
		"grade": "",
		"className": "",
		"identityStatus": 0,
		"lastLoginIp": "",
		"major": "",
		"studentId": "",
		"role": "",
		"status": 0,
		"creditScore": 0,
		"roleType": "",
		"createTime": "",
		"lastLoginTime": "",
		"createdAt": "",
		"updatedAt": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户列表（分页）


**接口地址**:`/api/api/admin/user/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|UserQueryRequest|UserQueryRequest|
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||
|&emsp;&emsp;username|||false|string||
|&emsp;&emsp;realName|||false|string||
|&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;college|||false|string||
|&emsp;&emsp;major|||false|string||
|&emsp;&emsp;grade|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;roleType|||false|string||
|&emsp;&emsp;identityStatus|||false|integer(int32)||
|&emsp;&emsp;keyword|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultPageData|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||PageData|PageData|
|&emsp;&emsp;records||array|UserListResponse|
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;username||string||
|&emsp;&emsp;&emsp;&emsp;realName||string||
|&emsp;&emsp;&emsp;&emsp;nickname||string||
|&emsp;&emsp;&emsp;&emsp;email||string||
|&emsp;&emsp;&emsp;&emsp;phone||string||
|&emsp;&emsp;&emsp;&emsp;avatar||string||
|&emsp;&emsp;&emsp;&emsp;gender||integer||
|&emsp;&emsp;&emsp;&emsp;studentId||string||
|&emsp;&emsp;&emsp;&emsp;college||string||
|&emsp;&emsp;&emsp;&emsp;major||string||
|&emsp;&emsp;&emsp;&emsp;grade||string||
|&emsp;&emsp;&emsp;&emsp;className||string||
|&emsp;&emsp;&emsp;&emsp;identityStatus||integer||
|&emsp;&emsp;&emsp;&emsp;creditScore||integer||
|&emsp;&emsp;&emsp;&emsp;totalReservations||integer||
|&emsp;&emsp;&emsp;&emsp;completedReservations||integer||
|&emsp;&emsp;&emsp;&emsp;violationCount||integer||
|&emsp;&emsp;&emsp;&emsp;roleType||string||
|&emsp;&emsp;&emsp;&emsp;status||integer||
|&emsp;&emsp;&emsp;&emsp;lastLoginTime||string||
|&emsp;&emsp;&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;total||integer(int64)||
|&emsp;&emsp;pageNum||integer(int64)||
|&emsp;&emsp;pageSize||integer(int64)||
|&emsp;&emsp;pages||integer(int64)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"records": [
			{
				"id": 0,
				"username": "",
				"realName": "",
				"nickname": "",
				"email": "",
				"phone": "",
				"avatar": "",
				"gender": 0,
				"studentId": "",
				"college": "",
				"major": "",
				"grade": "",
				"className": "",
				"identityStatus": 0,
				"creditScore": 0,
				"totalReservations": 0,
				"completedReservations": 0,
				"violationCount": 0,
				"roleType": "",
				"status": 0,
				"lastLoginTime": "",
				"lastLoginIp": "",
				"createTime": ""
			}
		],
		"total": 0,
		"pageNum": 0,
		"pageSize": 0,
		"pages": 0
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 重置用户密码


**接口地址**:`/api/api/admin/user/reset-password/{id}`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultString|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": "",
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 启用-禁用用户


**接口地址**:`/api/api/admin/user/status/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|status||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserVO|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"gender": 0,
		"college": "",
		"grade": "",
		"className": "",
		"identityStatus": 0,
		"lastLoginIp": "",
		"major": "",
		"studentId": "",
		"role": "",
		"status": 0,
		"creditScore": 0,
		"roleType": "",
		"createTime": "",
		"lastLoginTime": "",
		"createdAt": "",
		"updatedAt": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新用户


**接口地址**:`/api/api/admin/user/update/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "name": "",
  "email": "",
  "phone": "",
  "college": "",
  "major": "",
  "studentId": "",
  "role": "",
  "creditScore": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|userUpdateRequest|UserUpdateRequest|body|true|UserUpdateRequest|UserUpdateRequest|
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;college|||false|string||
|&emsp;&emsp;major|||false|string||
|&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;role|||false|string||
|&emsp;&emsp;creditScore|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserVO|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"gender": 0,
		"college": "",
		"grade": "",
		"className": "",
		"identityStatus": 0,
		"lastLoginIp": "",
		"major": "",
		"studentId": "",
		"role": "",
		"status": 0,
		"creditScore": 0,
		"roleType": "",
		"createTime": "",
		"lastLoginTime": "",
		"createdAt": "",
		"updatedAt": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 管理员账户管理接口


## 批量导入管理员


**接口地址**:`/api/admin/admin/batch-import`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "users": [
    {
      "username": "",
      "password": "",
      "name": "",
      "email": "",
      "phone": "",
      "college": "",
      "major": "",
      "studentId": "",
      "role": "",
      "creditScore": 0
    }
  ]
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|batchImportRequest|BatchImportRequest|body|true|BatchImportRequest|BatchImportRequest|
|&emsp;&emsp;users|||false|array|UserCreateRequest|
|&emsp;&emsp;&emsp;&emsp;username|||false|string||
|&emsp;&emsp;&emsp;&emsp;password|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;&emsp;&emsp;email|||false|string||
|&emsp;&emsp;&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;&emsp;&emsp;college|||false|string||
|&emsp;&emsp;&emsp;&emsp;major|||false|string||
|&emsp;&emsp;&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;&emsp;&emsp;role|||false|string||
|&emsp;&emsp;&emsp;&emsp;creditScore|||false|integer||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 创建管理员账户


**接口地址**:`/api/admin/admin/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "username": "",
  "password": "",
  "name": "",
  "email": "",
  "phone": "",
  "college": "",
  "major": "",
  "studentId": "",
  "role": "",
  "creditScore": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userCreateRequest|UserCreateRequest|body|true|UserCreateRequest|UserCreateRequest|
|&emsp;&emsp;username|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;college|||false|string||
|&emsp;&emsp;major|||false|string||
|&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;role|||false|string||
|&emsp;&emsp;creditScore|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 删除管理员账户


**接口地址**:`/api/admin/admin/delete/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取管理员详情


**接口地址**:`/api/admin/admin/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserVO|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"gender": 0,
		"college": "",
		"grade": "",
		"className": "",
		"identityStatus": 0,
		"lastLoginIp": "",
		"major": "",
		"studentId": "",
		"role": "",
		"status": 0,
		"creditScore": 0,
		"roleType": "",
		"createTime": "",
		"lastLoginTime": "",
		"createdAt": "",
		"updatedAt": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取管理员列表


**接口地址**:`/api/admin/admin/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|UserQueryRequest|UserQueryRequest|
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||
|&emsp;&emsp;username|||false|string||
|&emsp;&emsp;realName|||false|string||
|&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;college|||false|string||
|&emsp;&emsp;major|||false|string||
|&emsp;&emsp;grade|||false|string||
|&emsp;&emsp;status|||false|integer(int32)||
|&emsp;&emsp;roleType|||false|string||
|&emsp;&emsp;identityStatus|||false|integer(int32)||
|&emsp;&emsp;keyword|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListUserVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|UserVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;gender||integer(int32)||
|&emsp;&emsp;college||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;identityStatus||integer(int32)||
|&emsp;&emsp;lastLoginIp||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;role||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createdAt||string(date-time)||
|&emsp;&emsp;updatedAt||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"username": "",
			"realName": "",
			"nickname": "",
			"email": "",
			"phone": "",
			"avatar": "",
			"gender": 0,
			"college": "",
			"grade": "",
			"className": "",
			"identityStatus": 0,
			"lastLoginIp": "",
			"major": "",
			"studentId": "",
			"role": "",
			"status": 0,
			"creditScore": 0,
			"roleType": "",
			"createTime": "",
			"lastLoginTime": "",
			"createdAt": "",
			"updatedAt": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 重置管理员密码


**接口地址**:`/api/admin/admin/reset-password/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|newPassword||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新管理员状态


**接口地址**:`/api/admin/admin/status/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|status||query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新管理员信息


**接口地址**:`/api/admin/admin/update/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "name": "",
  "email": "",
  "phone": "",
  "college": "",
  "major": "",
  "studentId": "",
  "role": "",
  "creditScore": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|userUpdateRequest|UserUpdateRequest|body|true|UserUpdateRequest|UserUpdateRequest|
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;phone|||false|string||
|&emsp;&emsp;college|||false|string||
|&emsp;&emsp;major|||false|string||
|&emsp;&emsp;studentId|||false|string||
|&emsp;&emsp;role|||false|string||
|&emsp;&emsp;creditScore|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 签到管理接口(管理员可用)


## 清理超时签到


**接口地址**:`/api/admin/checkin/cleanup`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取签到记录详情


**接口地址**:`/api/admin/checkin/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultCheckInRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||CheckInRecordVO|CheckInRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;deviceInfo||string||
|&emsp;&emsp;ipAddress||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;remarks||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"reservationId": 0,
		"userId": 0,
		"roomId": 0,
		"seatId": 0,
		"checkInTime": "",
		"checkOutTime": "",
		"leaveTime": "",
		"returnTime": "",
		"status": "",
		"checkInMethod": "",
		"actualDuration": 0,
		"leaveDuration": 0,
		"maxLeaveMinutes": 0,
		"deviceInfo": "",
		"ipAddress": "",
		"location": "",
		"remarks": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取签到记录列表


**接口地址**:`/api/admin/checkin/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|params||query|true|object||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListCheckInRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|CheckInRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;deviceInfo||string||
|&emsp;&emsp;ipAddress||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;remarks||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"reservationId": 0,
			"userId": 0,
			"roomId": 0,
			"seatId": 0,
			"checkInTime": "",
			"checkOutTime": "",
			"leaveTime": "",
			"returnTime": "",
			"status": "",
			"checkInMethod": "",
			"actualDuration": 0,
			"leaveDuration": 0,
			"maxLeaveMinutes": 0,
			"deviceInfo": "",
			"ipAddress": "",
			"location": "",
			"remarks": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取签到统计


**接口地址**:`/api/admin/checkin/statistics`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 认证接口


## 获取验证码


**接口地址**:`/api/auth/captcha`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 修改密码


**接口地址**:`/api/auth/change-password`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "oldPassword": "",
  "newPassword": "",
  "confirmPassword": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|changePasswordRequest|修改密码请求|body|true|ChangePasswordRequest|ChangePasswordRequest|
|&emsp;&emsp;oldPassword|原密码||true|string||
|&emsp;&emsp;newPassword|新密码||true|string||
|&emsp;&emsp;confirmPassword|确认密码||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVoid|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 用户登录


**接口地址**:`/api/auth/login`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "username": "",
  "password": "",
  "captchaCode": "",
  "captchaKey": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|loginRequest|登录请求|body|true|LoginRequest|LoginRequest|
|&emsp;&emsp;username|用户名||true|string||
|&emsp;&emsp;password|密码||true|string||
|&emsp;&emsp;captchaCode|验证码||true|string||
|&emsp;&emsp;captchaKey|验证码key（从获取验证码接口返回）||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultLoginResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||LoginResponse|LoginResponse|
|&emsp;&emsp;accessToken|访问令牌|string||
|&emsp;&emsp;refreshToken|刷新令牌|string||
|&emsp;&emsp;tokenType|令牌类型|string||
|&emsp;&emsp;expiresIn|过期时间（秒）|integer(int64)||
|&emsp;&emsp;userId|用户ID|integer(int64)||
|&emsp;&emsp;username|用户名|string||
|&emsp;&emsp;role|用户角色|string||
|&emsp;&emsp;realName|真实姓名|string||
|&emsp;&emsp;avatar|头像|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"accessToken": "",
		"refreshToken": "",
		"tokenType": "",
		"expiresIn": 0,
		"userId": 0,
		"username": "",
		"role": "",
		"realName": "",
		"avatar": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 用户登出


**接口地址**:`/api/auth/logout`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVoid|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取当前用户信息


**接口地址**:`/api/auth/me`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserInfoResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserInfoResponse|UserInfoResponse|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;college||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"studentId": "",
		"college": "",
		"major": "",
		"grade": "",
		"className": "",
		"creditScore": 0,
		"roleType": "",
		"status": 0,
		"lastLoginTime": "",
		"createTime": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新用户信息


**接口地址**:`/api/auth/profile`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "nickname": "",
  "email": "",
  "phone": "",
  "avatar": "",
  "college": "",
  "major": "",
  "grade": "",
  "className": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|updateProfileRequest|更新用户资料请求|body|true|UpdateProfileRequest|UpdateProfileRequest|
|&emsp;&emsp;nickname|昵称||false|string||
|&emsp;&emsp;email|邮箱||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;avatar|头像URL||false|string||
|&emsp;&emsp;college|学院||false|string||
|&emsp;&emsp;major|专业||false|string||
|&emsp;&emsp;grade|年级||false|string||
|&emsp;&emsp;className|班级||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserInfoResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserInfoResponse|UserInfoResponse|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;college||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"studentId": "",
		"college": "",
		"major": "",
		"grade": "",
		"className": "",
		"creditScore": 0,
		"roleType": "",
		"status": 0,
		"lastLoginTime": "",
		"createTime": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 刷新Token


**接口地址**:`/api/auth/refresh`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "refreshToken": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|refreshTokenRequest|刷新Token请求|body|true|RefreshTokenRequest|RefreshTokenRequest|
|&emsp;&emsp;refreshToken|刷新Token||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultRefreshTokenResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||RefreshTokenResponse|RefreshTokenResponse|
|&emsp;&emsp;accessToken|新的访问令牌|string||
|&emsp;&emsp;tokenType|令牌类型|string||
|&emsp;&emsp;expiresIn|过期时间（秒）|integer(int64)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"accessToken": "",
		"tokenType": "",
		"expiresIn": 0
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 用户注册


**接口地址**:`/api/auth/register`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "username": "",
  "password": "",
  "confirmPassword": "",
  "realName": "",
  "email": "",
  "phone": "",
  "studentId": "",
  "college": "",
  "major": "",
  "grade": "",
  "className": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|registerRequest|注册请求|body|true|RegisterRequest|RegisterRequest|
|&emsp;&emsp;username|用户名||true|string||
|&emsp;&emsp;password|密码||true|string||
|&emsp;&emsp;confirmPassword|确认密码||true|string||
|&emsp;&emsp;realName|真实姓名||true|string||
|&emsp;&emsp;email|邮箱||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;studentId|学号||false|string||
|&emsp;&emsp;college|学院||false|string||
|&emsp;&emsp;major|专业||false|string||
|&emsp;&emsp;grade|年级||false|string||
|&emsp;&emsp;className|班级||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVoid|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 重置密码


**接口地址**:`/api/auth/reset-password`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|token||query|true|string||
|newPassword||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVoid|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 重置密码请求


**接口地址**:`/api/auth/reset-password/request`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|email||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVoid|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 实名认证


**接口地址**:`/api/auth/verify-identity`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "realName": "",
  "idCard": "",
  "studentId": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|verifyIdentityRequest|VerifyIdentityRequest|body|true|VerifyIdentityRequest|VerifyIdentityRequest|
|&emsp;&emsp;realName|||true|string||
|&emsp;&emsp;idCard|||true|string||
|&emsp;&emsp;studentId|||true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVerifyIdentityResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||VerifyIdentityResponse|VerifyIdentityResponse|
|&emsp;&emsp;verified||boolean||
|&emsp;&emsp;message||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;idCard||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"verified": true,
		"message": "",
		"realName": "",
		"idCard": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 日志管理接口


## 获取系统日志列表


**接口地址**:`/api/api/admin/logs`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page||query|false|integer(int32)||
|pageSize||query|false|integer(int32)||
|level||query|false|string||
|startDate||query|false|string||
|endDate||query|false|string||
|keyword||query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListSystemLogVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|SystemLogVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;level||string||
|&emsp;&emsp;message||string||
|&emsp;&emsp;timestamp||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;ip||string||
|&emsp;&emsp;userAgent||string||
|&emsp;&emsp;operation||string||
|&emsp;&emsp;module||string||
|&emsp;&emsp;details||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"level": "",
			"message": "",
			"timestamp": "",
			"userId": 0,
			"username": "",
			"ip": "",
			"userAgent": "",
			"operation": "",
			"module": "",
			"details": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 清理过期日志


**接口地址**:`/api/api/admin/logs/cleanup`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|days||query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultInteger|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||integer(int32)|integer(int32)|
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": 0,
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取日志详情


**接口地址**:`/api/api/admin/logs/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultSystemLogVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||SystemLogVO|SystemLogVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;level||string||
|&emsp;&emsp;message||string||
|&emsp;&emsp;timestamp||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;ip||string||
|&emsp;&emsp;userAgent||string||
|&emsp;&emsp;operation||string||
|&emsp;&emsp;module||string||
|&emsp;&emsp;details||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"level": "",
		"message": "",
		"timestamp": "",
		"userId": 0,
		"username": "",
		"ip": "",
		"userAgent": "",
		"operation": "",
		"module": "",
		"details": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取日志统计


**接口地址**:`/api/api/admin/logs/statistics`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 统计分析接口


## 导出统计数据


**接口地址**:`/api/admin/statistics/export`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "queryRequest": {
    "startDate": "",
    "endDate": "",
    "roomId": 0,
    "userId": 0,
    "statisticsType": "",
    "roomType": "",
    "userType": "",
    "pageNum": 0,
    "pageSize": 0
  },
  "exportType": "",
  "exportFormat": "",
  "fileName": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|exportRequest|ExportRequest|body|true|ExportRequest|ExportRequest|
|&emsp;&emsp;queryRequest|||false|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;&emsp;&emsp;startDate|||false|string||
|&emsp;&emsp;&emsp;&emsp;endDate|||false|string||
|&emsp;&emsp;&emsp;&emsp;roomId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;userId|||false|integer||
|&emsp;&emsp;&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;&emsp;&emsp;pageNum|||false|integer||
|&emsp;&emsp;&emsp;&emsp;pageSize|||false|integer||
|&emsp;&emsp;exportType|||false|string||
|&emsp;&emsp;exportFormat|||false|string||
|&emsp;&emsp;fileName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约热力图数据


**接口地址**:`/api/admin/statistics/heatmap`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|startDate||query|true|string(date)||
|endDate||query|true|string(date)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间平均使用时长


**接口地址**:`/api/admin/statistics/room/average-time`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间预约取消率


**接口地址**:`/api/admin/statistics/room/cancellation`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间类型分布


**接口地址**:`/api/admin/statistics/room/distribution`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间高峰期分析


**接口地址**:`/api/admin/statistics/room/peak`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间使用率排名


**接口地址**:`/api/admin/statistics/room/rank`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间座位使用情况


**接口地址**:`/api/admin/statistics/room/seat`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间每日使用趋势


**接口地址**:`/api/admin/statistics/room/trend`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|startDate||query|true|string(date)||
|endDate||query|true|string(date)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取房间使用情况统计


**接口地址**:`/api/admin/statistics/room/usage`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 生成统计快照


**接口地址**:`/api/admin/statistics/snapshot/generate`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取每日统计快照


**接口地址**:`/api/admin/statistics/snapshots`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|startDate||query|true|string(date)||
|endDate||query|true|string(date)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取系统总体统计数据


**接口地址**:`/api/admin/statistics/system`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取时间段使用统计


**接口地址**:`/api/admin/statistics/time-slot`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户平均使用时长


**接口地址**:`/api/admin/statistics/user/average-time`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户预约行为分析


**接口地址**:`/api/admin/statistics/user/behavior`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户信用分分布


**接口地址**:`/api/admin/statistics/user/credit`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户类型分布


**接口地址**:`/api/admin/statistics/user/distribution`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户增长趋势


**接口地址**:`/api/admin/statistics/user/growth`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|startDate||query|true|string(date)||
|endDate||query|true|string(date)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户画像分析


**接口地址**:`/api/admin/statistics/user/profile`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户活跃度排名


**接口地址**:`/api/admin/statistics/user/rank`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户留存率分析


**接口地址**:`/api/admin/statistics/user/retention`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|startDate||query|true|string(date)||
|endDate||query|true|string(date)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户使用情况统计


**接口地址**:`/api/admin/statistics/user/usage`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户违规情况统计


**接口地址**:`/api/admin/statistics/user/violation`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|StatisticsQueryRequest|StatisticsQueryRequest|
|&emsp;&emsp;startDate|||false|string(date)||
|&emsp;&emsp;endDate|||false|string(date)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;statisticsType|||false|string||
|&emsp;&emsp;roomType|||false|string||
|&emsp;&emsp;userType|||false|string||
|&emsp;&emsp;pageNum|||false|integer(int32)||
|&emsp;&emsp;pageSize|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 违规管理接口(管理员可用)


## 获取违规记录详情


**接口地址**:`/api/admin/violation/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultViolationRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||ViolationRecordVO|ViolationRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;violationDesc||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;recordTime||string(date-time)||
|&emsp;&emsp;handleTime||string(date-time)||
|&emsp;&emsp;handlerId||integer(int64)||
|&emsp;&emsp;handleResult||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;evidence||string||
|&emsp;&emsp;remarks||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"userId": 0,
		"violationType": "",
		"violationDesc": "",
		"status": "",
		"recordTime": "",
		"handleTime": "",
		"handlerId": 0,
		"handleResult": "",
		"deductCredit": 0,
		"evidence": "",
		"remarks": "",
		"createTime": "",
		"updateTime": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 处理违规


**接口地址**:`/api/admin/violation/handle`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "violationId": 0,
  "status": "",
  "handleResult": "",
  "deductCredit": 0,
  "remarks": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|violationHandleRequest|ViolationHandleRequest|body|true|ViolationHandleRequest|ViolationHandleRequest|
|&emsp;&emsp;violationId|||false|integer(int64)||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;handleResult|||false|string||
|&emsp;&emsp;deductCredit|||false|integer(int32)||
|&emsp;&emsp;remarks|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取违规记录列表


**接口地址**:`/api/admin/violation/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|params||query|true|object||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListViolationRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|ViolationRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;violationDesc||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;recordTime||string(date-time)||
|&emsp;&emsp;handleTime||string(date-time)||
|&emsp;&emsp;handlerId||integer(int64)||
|&emsp;&emsp;handleResult||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;evidence||string||
|&emsp;&emsp;remarks||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"userId": 0,
			"violationType": "",
			"violationDesc": "",
			"status": "",
			"recordTime": "",
			"handleTime": "",
			"handlerId": 0,
			"handleResult": "",
			"deductCredit": 0,
			"evidence": "",
			"remarks": "",
			"createTime": "",
			"updateTime": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 记录违规


**接口地址**:`/api/admin/violation/record`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "id": 0,
  "userId": 0,
  "violationType": "",
  "violationDesc": "",
  "status": "",
  "recordTime": "",
  "handleTime": "",
  "handlerId": 0,
  "handleResult": "",
  "deductCredit": 0,
  "evidence": "",
  "remarks": "",
  "createTime": "",
  "updateTime": "",
  "deleted": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|violationRecord|ViolationRecord|body|true|ViolationRecord|ViolationRecord|
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;violationType|||false|string||
|&emsp;&emsp;violationDesc|||false|string||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;recordTime|||false|string(date-time)||
|&emsp;&emsp;handleTime|||false|string(date-time)||
|&emsp;&emsp;handlerId|||false|integer(int64)||
|&emsp;&emsp;handleResult|||false|string||
|&emsp;&emsp;deductCredit|||false|integer(int32)||
|&emsp;&emsp;evidence|||false|string||
|&emsp;&emsp;remarks|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;deleted|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取违规统计


**接口地址**:`/api/admin/violation/statistics`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户违规记录


**接口地址**:`/api/admin/violation/user/{userId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListViolationRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|ViolationRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;violationDesc||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;recordTime||string(date-time)||
|&emsp;&emsp;handleTime||string(date-time)||
|&emsp;&emsp;handlerId||integer(int64)||
|&emsp;&emsp;handleResult||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;evidence||string||
|&emsp;&emsp;remarks||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"userId": 0,
			"violationType": "",
			"violationDesc": "",
			"status": "",
			"recordTime": "",
			"handleTime": "",
			"handlerId": 0,
			"handleResult": "",
			"deductCredit": 0,
			"evidence": "",
			"remarks": "",
			"createTime": "",
			"updateTime": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 系统设置接口


## 获取系统设置


**接口地址**:`/api/api/admin/settings`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultSystemSettingsVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||SystemSettingsVO|SystemSettingsVO|
|&emsp;&emsp;systemName||string||
|&emsp;&emsp;systemVersion||string||
|&emsp;&emsp;enableRegistration||boolean||
|&emsp;&emsp;enableEmailVerification||boolean||
|&emsp;&emsp;enableSmsVerification||boolean||
|&emsp;&emsp;maxLoginAttempts||integer(int32)||
|&emsp;&emsp;lockoutDurationMinutes||integer(int32)||
|&emsp;&emsp;defaultTimeZone||string||
|&emsp;&emsp;defaultLanguage||string||
|&emsp;&emsp;lastUpdated||string(date-time)||
|&emsp;&emsp;lastUpdatedBy||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"systemName": "",
		"systemVersion": "",
		"enableRegistration": true,
		"enableEmailVerification": true,
		"enableSmsVerification": true,
		"maxLoginAttempts": 0,
		"lockoutDurationMinutes": 0,
		"defaultTimeZone": "",
		"defaultLanguage": "",
		"lastUpdated": "",
		"lastUpdatedBy": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新系统设置


**接口地址**:`/api/api/admin/settings`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "systemName": "",
  "systemVersion": "",
  "enableRegistration": true,
  "enableEmailVerification": true,
  "enableSmsVerification": true,
  "maxLoginAttempts": 0,
  "lockoutDurationMinutes": 0,
  "defaultTimeZone": "",
  "defaultLanguage": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|systemSettingsUpdateRequest|SystemSettingsUpdateRequest|body|true|SystemSettingsUpdateRequest|SystemSettingsUpdateRequest|
|&emsp;&emsp;systemName|||false|string||
|&emsp;&emsp;systemVersion|||false|string||
|&emsp;&emsp;enableRegistration|||false|boolean||
|&emsp;&emsp;enableEmailVerification|||false|boolean||
|&emsp;&emsp;enableSmsVerification|||false|boolean||
|&emsp;&emsp;maxLoginAttempts|||false|integer(int32)||
|&emsp;&emsp;lockoutDurationMinutes|||false|integer(int32)||
|&emsp;&emsp;defaultTimeZone|||false|string||
|&emsp;&emsp;defaultLanguage|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultSystemSettingsVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||SystemSettingsVO|SystemSettingsVO|
|&emsp;&emsp;systemName||string||
|&emsp;&emsp;systemVersion||string||
|&emsp;&emsp;enableRegistration||boolean||
|&emsp;&emsp;enableEmailVerification||boolean||
|&emsp;&emsp;enableSmsVerification||boolean||
|&emsp;&emsp;maxLoginAttempts||integer(int32)||
|&emsp;&emsp;lockoutDurationMinutes||integer(int32)||
|&emsp;&emsp;defaultTimeZone||string||
|&emsp;&emsp;defaultLanguage||string||
|&emsp;&emsp;lastUpdated||string(date-time)||
|&emsp;&emsp;lastUpdatedBy||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"systemName": "",
		"systemVersion": "",
		"enableRegistration": true,
		"enableEmailVerification": true,
		"enableSmsVerification": true,
		"maxLoginAttempts": 0,
		"lockoutDurationMinutes": 0,
		"defaultTimeZone": "",
		"defaultLanguage": "",
		"lastUpdated": "",
		"lastUpdatedBy": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 备份系统数据


**接口地址**:`/api/api/admin/settings/backup`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 清理过期数据


**接口地址**:`/api/api/admin/settings/cleanup`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约规则设置


**接口地址**:`/api/api/admin/settings/reservation-rules`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultReservationRulesVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||ReservationRulesVO|ReservationRulesVO|
|&emsp;&emsp;maxReservationPerDay||integer(int32)||
|&emsp;&emsp;maxFutureDays||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;checkInEarlyMinutes||integer(int32)||
|&emsp;&emsp;checkInLateMinutes||integer(int32)||
|&emsp;&emsp;autoCancelMinutes||integer(int32)||
|&emsp;&emsp;tempLeaveMaxMinutes||integer(int32)||
|&emsp;&emsp;lastUpdated||string(date-time)||
|&emsp;&emsp;lastUpdatedBy||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"maxReservationPerDay": 0,
		"maxFutureDays": 0,
		"minReservationMinutes": 0,
		"maxReservationMinutes": 0,
		"checkInEarlyMinutes": 0,
		"checkInLateMinutes": 0,
		"autoCancelMinutes": 0,
		"tempLeaveMaxMinutes": 0,
		"lastUpdated": "",
		"lastUpdatedBy": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新预约规则设置


**接口地址**:`/api/api/admin/settings/reservation-rules`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "maxReservationPerDay": 0,
  "maxFutureDays": 0,
  "minReservationMinutes": 0,
  "maxReservationMinutes": 0,
  "checkInEarlyMinutes": 0,
  "checkInLateMinutes": 0,
  "autoCancelMinutes": 0,
  "tempLeaveMaxMinutes": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|reservationRulesUpdateRequest|ReservationRulesUpdateRequest|body|true|ReservationRulesUpdateRequest|ReservationRulesUpdateRequest|
|&emsp;&emsp;maxReservationPerDay|||false|integer(int32)||
|&emsp;&emsp;maxFutureDays|||false|integer(int32)||
|&emsp;&emsp;minReservationMinutes|||false|integer(int32)||
|&emsp;&emsp;maxReservationMinutes|||false|integer(int32)||
|&emsp;&emsp;checkInEarlyMinutes|||false|integer(int32)||
|&emsp;&emsp;checkInLateMinutes|||false|integer(int32)||
|&emsp;&emsp;autoCancelMinutes|||false|integer(int32)||
|&emsp;&emsp;tempLeaveMaxMinutes|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultReservationRulesVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||ReservationRulesVO|ReservationRulesVO|
|&emsp;&emsp;maxReservationPerDay||integer(int32)||
|&emsp;&emsp;maxFutureDays||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;checkInEarlyMinutes||integer(int32)||
|&emsp;&emsp;checkInLateMinutes||integer(int32)||
|&emsp;&emsp;autoCancelMinutes||integer(int32)||
|&emsp;&emsp;tempLeaveMaxMinutes||integer(int32)||
|&emsp;&emsp;lastUpdated||string(date-time)||
|&emsp;&emsp;lastUpdatedBy||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"maxReservationPerDay": 0,
		"maxFutureDays": 0,
		"minReservationMinutes": 0,
		"maxReservationMinutes": 0,
		"checkInEarlyMinutes": 0,
		"checkInLateMinutes": 0,
		"autoCancelMinutes": 0,
		"tempLeaveMaxMinutes": 0,
		"lastUpdated": "",
		"lastUpdatedBy": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 学生签到接口


## 获取当前签到信息


**接口地址**:`/api/student/checkin/current`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultCheckInRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||CheckInRecordVO|CheckInRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;deviceInfo||string||
|&emsp;&emsp;ipAddress||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;remarks||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"reservationId": 0,
		"userId": 0,
		"roomId": 0,
		"seatId": 0,
		"checkInTime": "",
		"checkOutTime": "",
		"leaveTime": "",
		"returnTime": "",
		"status": "",
		"checkInMethod": "",
		"actualDuration": 0,
		"leaveDuration": 0,
		"maxLeaveMinutes": 0,
		"deviceInfo": "",
		"ipAddress": "",
		"location": "",
		"remarks": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取签到记录详情


**接口地址**:`/api/student/checkin/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultCheckInRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||CheckInRecordVO|CheckInRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;deviceInfo||string||
|&emsp;&emsp;ipAddress||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;remarks||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"reservationId": 0,
		"userId": 0,
		"roomId": 0,
		"seatId": 0,
		"checkInTime": "",
		"checkOutTime": "",
		"leaveTime": "",
		"returnTime": "",
		"status": "",
		"checkInMethod": "",
		"actualDuration": 0,
		"leaveDuration": 0,
		"maxLeaveMinutes": 0,
		"deviceInfo": "",
		"ipAddress": "",
		"location": "",
		"remarks": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 签到


**接口地址**:`/api/student/checkin/in`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "reservationId": 0,
  "seatId": 0,
  "roomId": 0,
  "checkInMethod": "",
  "deviceInfo": "",
  "ipAddress": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|checkInRequest|CheckInRequest|body|true|CheckInRequest|CheckInRequest|
|&emsp;&emsp;reservationId|||false|integer(int64)||
|&emsp;&emsp;seatId|||false|integer(int64)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;checkInMethod|||false|string||
|&emsp;&emsp;deviceInfo|||false|string||
|&emsp;&emsp;ipAddress|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultCheckInResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||CheckInResponse|CheckInResponse|
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;message||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"checkInTime": "",
		"seatId": 0,
		"roomId": 0,
		"checkInMethod": "",
		"message": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 暂离


**接口地址**:`/api/student/checkin/leave`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "checkInId": 0,
  "maxLeaveMinutes": 0,
  "remarks": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|leaveRequest|LeaveRequest|body|true|LeaveRequest|LeaveRequest|
|&emsp;&emsp;checkInId|||false|integer(int64)||
|&emsp;&emsp;maxLeaveMinutes|||false|integer(int32)||
|&emsp;&emsp;remarks|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户签到记录


**接口地址**:`/api/student/checkin/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListCheckInRecordVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|CheckInRecordVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationId||integer(int64)||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;deviceInfo||string||
|&emsp;&emsp;ipAddress||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;remarks||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"reservationId": 0,
			"userId": 0,
			"roomId": 0,
			"seatId": 0,
			"checkInTime": "",
			"checkOutTime": "",
			"leaveTime": "",
			"returnTime": "",
			"status": "",
			"checkInMethod": "",
			"actualDuration": 0,
			"leaveDuration": 0,
			"maxLeaveMinutes": 0,
			"deviceInfo": "",
			"ipAddress": "",
			"location": "",
			"remarks": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 签退


**接口地址**:`/api/student/checkin/out`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "checkInId": 0,
  "remarks": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|checkOutRequest|CheckOutRequest|body|true|CheckOutRequest|CheckOutRequest|
|&emsp;&emsp;checkInId|||false|integer(int64)||
|&emsp;&emsp;remarks|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 生成签到二维码


**接口地址**:`/api/student/checkin/qrcode`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|reservationId||query|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultQRCodeResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||QRCodeResponse|QRCodeResponse|
|&emsp;&emsp;qrCode||string||
|&emsp;&emsp;expireTime||string(date-time)||
|&emsp;&emsp;message||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"qrCode": "",
		"expireTime": "",
		"message": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 回来


**接口地址**:`/api/student/checkin/return`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "checkInId": 0,
  "maxLeaveMinutes": 0,
  "remarks": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|leaveRequest|LeaveRequest|body|true|LeaveRequest|LeaveRequest|
|&emsp;&emsp;checkInId|||false|integer(int64)||
|&emsp;&emsp;maxLeaveMinutes|||false|integer(int32)||
|&emsp;&emsp;remarks|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 验证签到二维码


**接口地址**:`/api/student/checkin/verify-qrcode`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|qrCode||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 学生预约接口


## 检查座位可用性


**接口地址**:`/api/api/student/reservation/availability`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||query|true|integer(int64)||
|seatId||query|true|integer(int64)||
|startTime||query|true|string||
|endTime||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultAvailabilityResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||AvailabilityResponse|AvailabilityResponse|
|&emsp;&emsp;available||boolean||
|&emsp;&emsp;reason||string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"available": true,
		"reason": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 取消预约


**接口地址**:`/api/api/student/reservation/cancel`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "reservationId": 0,
  "cancelReason": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|reservationCancelRequest|ReservationCancelRequest|body|true|ReservationCancelRequest|ReservationCancelRequest|
|&emsp;&emsp;reservationId|||false|integer(int64)||
|&emsp;&emsp;cancelReason|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 确认预约


**接口地址**:`/api/api/student/reservation/check`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "reservationId": 0,
  "checkInMethod": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|reservationCheckRequest|ReservationCheckRequest|body|true|ReservationCheckRequest|ReservationCheckRequest|
|&emsp;&emsp;reservationId|||false|integer(int64)||
|&emsp;&emsp;checkInMethod|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 创建预约


**接口地址**:`/api/api/student/reservation/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "roomId": 0,
  "seatId": 0,
  "startTime": "",
  "endTime": "",
  "expectedDuration": 0,
  "reservationType": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|reservationCreateRequest|ReservationCreateRequest|body|true|ReservationCreateRequest|ReservationCreateRequest|
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatId|||false|integer(int64)||
|&emsp;&emsp;startTime|||false|string(date-time)||
|&emsp;&emsp;endTime|||false|string(date-time)||
|&emsp;&emsp;expectedDuration|||false|integer(int32)||
|&emsp;&emsp;reservationType|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约详情


**接口地址**:`/api/api/student/reservation/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultReservationVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||ReservationVO|ReservationVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationNo||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;startTime||string(date-time)||
|&emsp;&emsp;endTime||string(date-time)||
|&emsp;&emsp;expectedDuration||integer(int32)||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;cancelReason||string||
|&emsp;&emsp;cancelTime||string(date-time)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;checkInQrcode||string||
|&emsp;&emsp;checkInQrcodeExpire||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;isViolation||integer(int32)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;reservationType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;statusEnum|可用值:PENDING,CONFIRMED,CHECKED_IN,IN_USE,TEMPORARY_LEAVE,COMPLETED,CANCELLED,NO_SHOW,EXPIRED|string||
|&emsp;&emsp;reservationTypeEnum|可用值:NORMAL,IMMEDIATE,RECURRING,GROUP,EXAM|string||
|&emsp;&emsp;checkInMethodEnum|可用值:QRCODE,FACE,MANUAL,SYSTEM,ADMIN,CARD|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"reservationNo": "",
		"userId": 0,
		"seatId": 0,
		"roomId": 0,
		"startTime": "",
		"endTime": "",
		"expectedDuration": 0,
		"actualDuration": 0,
		"status": "",
		"cancelReason": "",
		"cancelTime": "",
		"checkInTime": "",
		"checkOutTime": "",
		"checkInMethod": "",
		"checkInQrcode": "",
		"checkInQrcodeExpire": "",
		"leaveTime": "",
		"returnTime": "",
		"leaveDuration": 0,
		"maxLeaveMinutes": 0,
		"isViolation": 0,
		"violationType": "",
		"deductCredit": 0,
		"reservationType": "",
		"createTime": "",
		"updateTime": "",
		"statusEnum": "",
		"reservationTypeEnum": "",
		"checkInMethodEnum": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 计算预约费用


**接口地址**:`/api/api/student/reservation/fee`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|ReservationCreateRequest|ReservationCreateRequest|
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatId|||false|integer(int64)||
|&emsp;&emsp;startTime|||false|string(date-time)||
|&emsp;&emsp;endTime|||false|string(date-time)||
|&emsp;&emsp;expectedDuration|||false|integer(int32)||
|&emsp;&emsp;reservationType|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultDouble|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||number(double)|number(double)|
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": 0,
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取用户预约列表


**接口地址**:`/api/api/student/reservation/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|ReservationQueryRequest|ReservationQueryRequest|
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatId|||false|integer(int64)||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;reservationType|||false|string||
|&emsp;&emsp;startDate|||false|string||
|&emsp;&emsp;endDate|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListReservationVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|ReservationVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationNo||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;startTime||string(date-time)||
|&emsp;&emsp;endTime||string(date-time)||
|&emsp;&emsp;expectedDuration||integer(int32)||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;cancelReason||string||
|&emsp;&emsp;cancelTime||string(date-time)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;checkInQrcode||string||
|&emsp;&emsp;checkInQrcodeExpire||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;isViolation||integer(int32)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;reservationType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;statusEnum|可用值:PENDING,CONFIRMED,CHECKED_IN,IN_USE,TEMPORARY_LEAVE,COMPLETED,CANCELLED,NO_SHOW,EXPIRED|string||
|&emsp;&emsp;reservationTypeEnum|可用值:NORMAL,IMMEDIATE,RECURRING,GROUP,EXAM|string||
|&emsp;&emsp;checkInMethodEnum|可用值:QRCODE,FACE,MANUAL,SYSTEM,ADMIN,CARD|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"reservationNo": "",
			"userId": 0,
			"seatId": 0,
			"roomId": 0,
			"startTime": "",
			"endTime": "",
			"expectedDuration": 0,
			"actualDuration": 0,
			"status": "",
			"cancelReason": "",
			"cancelTime": "",
			"checkInTime": "",
			"checkOutTime": "",
			"checkInMethod": "",
			"checkInQrcode": "",
			"checkInQrcodeExpire": "",
			"leaveTime": "",
			"returnTime": "",
			"leaveDuration": 0,
			"maxLeaveMinutes": 0,
			"isViolation": 0,
			"violationType": "",
			"deductCredit": 0,
			"reservationType": "",
			"createTime": "",
			"updateTime": "",
			"statusEnum": "",
			"reservationTypeEnum": "",
			"checkInMethodEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约统计


**接口地址**:`/api/api/student/reservation/statistics`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取即将开始的预约


**接口地址**:`/api/api/student/reservation/upcoming`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListReservationVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|ReservationVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationNo||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;startTime||string(date-time)||
|&emsp;&emsp;endTime||string(date-time)||
|&emsp;&emsp;expectedDuration||integer(int32)||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;cancelReason||string||
|&emsp;&emsp;cancelTime||string(date-time)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;checkInQrcode||string||
|&emsp;&emsp;checkInQrcodeExpire||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;isViolation||integer(int32)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;reservationType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;statusEnum|可用值:PENDING,CONFIRMED,CHECKED_IN,IN_USE,TEMPORARY_LEAVE,COMPLETED,CANCELLED,NO_SHOW,EXPIRED|string||
|&emsp;&emsp;reservationTypeEnum|可用值:NORMAL,IMMEDIATE,RECURRING,GROUP,EXAM|string||
|&emsp;&emsp;checkInMethodEnum|可用值:QRCODE,FACE,MANUAL,SYSTEM,ADMIN,CARD|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"reservationNo": "",
			"userId": 0,
			"seatId": 0,
			"roomId": 0,
			"startTime": "",
			"endTime": "",
			"expectedDuration": 0,
			"actualDuration": 0,
			"status": "",
			"cancelReason": "",
			"cancelTime": "",
			"checkInTime": "",
			"checkOutTime": "",
			"checkInMethod": "",
			"checkInQrcode": "",
			"checkInQrcodeExpire": "",
			"leaveTime": "",
			"returnTime": "",
			"leaveDuration": 0,
			"maxLeaveMinutes": 0,
			"isViolation": 0,
			"violationType": "",
			"deductCredit": 0,
			"reservationType": "",
			"createTime": "",
			"updateTime": "",
			"statusEnum": "",
			"reservationTypeEnum": "",
			"checkInMethodEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新预约


**接口地址**:`/api/api/student/reservation/update/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "roomId": 0,
  "seatId": 0,
  "startTime": "",
  "endTime": "",
  "expectedDuration": 0,
  "reservationType": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|reservationCreateRequest|ReservationCreateRequest|body|true|ReservationCreateRequest|ReservationCreateRequest|
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatId|||false|integer(int64)||
|&emsp;&emsp;startTime|||false|string(date-time)||
|&emsp;&emsp;endTime|||false|string(date-time)||
|&emsp;&emsp;expectedDuration|||false|integer(int32)||
|&emsp;&emsp;reservationType|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 用户接口


## 获取个人信息


**接口地址**:`/api/users/profile`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserInfoResponse|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||UserInfoResponse|UserInfoResponse|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;username||string||
|&emsp;&emsp;realName||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;studentId||string||
|&emsp;&emsp;college||string||
|&emsp;&emsp;major||string||
|&emsp;&emsp;grade||string||
|&emsp;&emsp;className||string||
|&emsp;&emsp;creditScore||integer(int32)||
|&emsp;&emsp;roleType||string||
|&emsp;&emsp;status||integer(int32)||
|&emsp;&emsp;lastLoginTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"username": "",
		"realName": "",
		"nickname": "",
		"email": "",
		"phone": "",
		"avatar": "",
		"studentId": "",
		"college": "",
		"major": "",
		"grade": "",
		"className": "",
		"creditScore": 0,
		"roleType": "",
		"status": 0,
		"lastLoginTime": "",
		"createTime": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新个人信息


**接口地址**:`/api/users/profile`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "nickname": "",
  "email": "",
  "phone": "",
  "avatar": "",
  "college": "",
  "major": "",
  "grade": "",
  "className": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|updateProfileRequest|更新用户资料请求|body|true|UpdateProfileRequest|UpdateProfileRequest|
|&emsp;&emsp;nickname|昵称||false|string||
|&emsp;&emsp;email|邮箱||false|string||
|&emsp;&emsp;phone|手机号||false|string||
|&emsp;&emsp;avatar|头像URL||false|string||
|&emsp;&emsp;college|学院||false|string||
|&emsp;&emsp;major|专业||false|string||
|&emsp;&emsp;grade|年级||false|string||
|&emsp;&emsp;className|班级||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVoid|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 预约管理接口(管理员可用)


## 清理过期预约


**接口地址**:`/api/admin/reservation/cleanup`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约详情


**接口地址**:`/api/admin/reservation/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultReservationVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||ReservationVO|ReservationVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationNo||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;startTime||string(date-time)||
|&emsp;&emsp;endTime||string(date-time)||
|&emsp;&emsp;expectedDuration||integer(int32)||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;cancelReason||string||
|&emsp;&emsp;cancelTime||string(date-time)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;checkInQrcode||string||
|&emsp;&emsp;checkInQrcodeExpire||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;isViolation||integer(int32)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;reservationType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;statusEnum|可用值:PENDING,CONFIRMED,CHECKED_IN,IN_USE,TEMPORARY_LEAVE,COMPLETED,CANCELLED,NO_SHOW,EXPIRED|string||
|&emsp;&emsp;reservationTypeEnum|可用值:NORMAL,IMMEDIATE,RECURRING,GROUP,EXAM|string||
|&emsp;&emsp;checkInMethodEnum|可用值:QRCODE,FACE,MANUAL,SYSTEM,ADMIN,CARD|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"reservationNo": "",
		"userId": 0,
		"seatId": 0,
		"roomId": 0,
		"startTime": "",
		"endTime": "",
		"expectedDuration": 0,
		"actualDuration": 0,
		"status": "",
		"cancelReason": "",
		"cancelTime": "",
		"checkInTime": "",
		"checkOutTime": "",
		"checkInMethod": "",
		"checkInQrcode": "",
		"checkInQrcodeExpire": "",
		"leaveTime": "",
		"returnTime": "",
		"leaveDuration": 0,
		"maxLeaveMinutes": 0,
		"isViolation": 0,
		"violationType": "",
		"deductCredit": 0,
		"reservationType": "",
		"createTime": "",
		"updateTime": "",
		"statusEnum": "",
		"reservationTypeEnum": "",
		"checkInMethodEnum": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约列表


**接口地址**:`/api/admin/reservation/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|ReservationQueryRequest|ReservationQueryRequest|
|&emsp;&emsp;userId|||false|integer(int64)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatId|||false|integer(int64)||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;reservationType|||false|string||
|&emsp;&emsp;startDate|||false|string||
|&emsp;&emsp;endDate|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListReservationVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|ReservationVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;reservationNo||string||
|&emsp;&emsp;userId||integer(int64)||
|&emsp;&emsp;seatId||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;startTime||string(date-time)||
|&emsp;&emsp;endTime||string(date-time)||
|&emsp;&emsp;expectedDuration||integer(int32)||
|&emsp;&emsp;actualDuration||integer(int32)||
|&emsp;&emsp;status||string||
|&emsp;&emsp;cancelReason||string||
|&emsp;&emsp;cancelTime||string(date-time)||
|&emsp;&emsp;checkInTime||string(date-time)||
|&emsp;&emsp;checkOutTime||string(date-time)||
|&emsp;&emsp;checkInMethod||string||
|&emsp;&emsp;checkInQrcode||string||
|&emsp;&emsp;checkInQrcodeExpire||string(date-time)||
|&emsp;&emsp;leaveTime||string(date-time)||
|&emsp;&emsp;returnTime||string(date-time)||
|&emsp;&emsp;leaveDuration||integer(int32)||
|&emsp;&emsp;maxLeaveMinutes||integer(int32)||
|&emsp;&emsp;isViolation||integer(int32)||
|&emsp;&emsp;violationType||string||
|&emsp;&emsp;deductCredit||integer(int32)||
|&emsp;&emsp;reservationType||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;statusEnum|可用值:PENDING,CONFIRMED,CHECKED_IN,IN_USE,TEMPORARY_LEAVE,COMPLETED,CANCELLED,NO_SHOW,EXPIRED|string||
|&emsp;&emsp;reservationTypeEnum|可用值:NORMAL,IMMEDIATE,RECURRING,GROUP,EXAM|string||
|&emsp;&emsp;checkInMethodEnum|可用值:QRCODE,FACE,MANUAL,SYSTEM,ADMIN,CARD|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"reservationNo": "",
			"userId": 0,
			"seatId": 0,
			"roomId": 0,
			"startTime": "",
			"endTime": "",
			"expectedDuration": 0,
			"actualDuration": 0,
			"status": "",
			"cancelReason": "",
			"cancelTime": "",
			"checkInTime": "",
			"checkOutTime": "",
			"checkInMethod": "",
			"checkInQrcode": "",
			"checkInQrcodeExpire": "",
			"leaveTime": "",
			"returnTime": "",
			"leaveDuration": 0,
			"maxLeaveMinutes": 0,
			"isViolation": 0,
			"violationType": "",
			"deductCredit": 0,
			"reservationType": "",
			"createTime": "",
			"updateTime": "",
			"statusEnum": "",
			"reservationTypeEnum": "",
			"checkInMethodEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取预约统计


**接口地址**:`/api/admin/reservation/statistics`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新预约状态


**接口地址**:`/api/admin/reservation/status/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|status||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 自习室管理接口(管理员可用)


## 获取可用自习室


**接口地址**:`/api/admin/room/available`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListRoomVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|RoomVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomCode||string||
|&emsp;&emsp;roomName||string||
|&emsp;&emsp;building||string||
|&emsp;&emsp;floor||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;coverImage||string||
|&emsp;&emsp;layoutImage||string||
|&emsp;&emsp;totalSeats||integer(int32)||
|&emsp;&emsp;availableSeats||integer(int32)||
|&emsp;&emsp;rowCount||integer(int32)||
|&emsp;&emsp;colCount||integer(int32)||
|&emsp;&emsp;layoutConfig||string||
|&emsp;&emsp;openStatus||integer(int32)||
|&emsp;&emsp;openTimeConfig||string||
|&emsp;&emsp;advanceReservationHours||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;facilities||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasWifi||integer(int32)||
|&emsp;&emsp;hasAirConditioner||integer(int32)||
|&emsp;&emsp;hasWater||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;averageRating||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomCode": "",
			"roomName": "",
			"building": "",
			"floor": "",
			"location": "",
			"description": "",
			"coverImage": "",
			"layoutImage": "",
			"totalSeats": 0,
			"availableSeats": 0,
			"rowCount": 0,
			"colCount": 0,
			"layoutConfig": "",
			"openStatus": 0,
			"openTimeConfig": "",
			"advanceReservationHours": 0,
			"minReservationMinutes": 0,
			"maxReservationMinutes": 0,
			"facilities": "",
			"hasPower": 0,
			"hasWifi": 0,
			"hasAirConditioner": 0,
			"hasWater": 0,
			"popularityScore": 0,
			"usageCount": 0,
			"averageRating": 0,
			"createTime": "",
			"updateTime": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 创建自习室


**接口地址**:`/api/admin/room/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "roomCode": "",
  "roomName": "",
  "building": "",
  "floor": "",
  "location": "",
  "description": "",
  "coverImage": "",
  "layoutImage": "",
  "totalSeats": 0,
  "rowCount": 0,
  "colCount": 0,
  "layoutConfig": "",
  "openTimeConfig": "",
  "advanceReservationHours": 0,
  "minReservationMinutes": 0,
  "maxReservationMinutes": 0,
  "facilities": "",
  "hasPower": 0,
  "hasWifi": 0,
  "hasAirConditioner": 0,
  "hasWater": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomCreateRequest|RoomCreateRequest|body|true|RoomCreateRequest|RoomCreateRequest|
|&emsp;&emsp;roomCode|||false|string||
|&emsp;&emsp;roomName|||false|string||
|&emsp;&emsp;building|||false|string||
|&emsp;&emsp;floor|||false|string||
|&emsp;&emsp;location|||false|string||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;coverImage|||false|string||
|&emsp;&emsp;layoutImage|||false|string||
|&emsp;&emsp;totalSeats|||false|integer(int32)||
|&emsp;&emsp;rowCount|||false|integer(int32)||
|&emsp;&emsp;colCount|||false|integer(int32)||
|&emsp;&emsp;layoutConfig|||false|string||
|&emsp;&emsp;openTimeConfig|||false|string||
|&emsp;&emsp;advanceReservationHours|||false|integer(int32)||
|&emsp;&emsp;minReservationMinutes|||false|integer(int32)||
|&emsp;&emsp;maxReservationMinutes|||false|integer(int32)||
|&emsp;&emsp;facilities|||false|string||
|&emsp;&emsp;hasPower|||false|integer(int32)||
|&emsp;&emsp;hasWifi|||false|integer(int32)||
|&emsp;&emsp;hasAirConditioner|||false|integer(int32)||
|&emsp;&emsp;hasWater|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 删除自习室


**接口地址**:`/api/admin/room/delete/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室详情


**接口地址**:`/api/admin/room/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultRoomVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||RoomVO|RoomVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomCode||string||
|&emsp;&emsp;roomName||string||
|&emsp;&emsp;building||string||
|&emsp;&emsp;floor||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;coverImage||string||
|&emsp;&emsp;layoutImage||string||
|&emsp;&emsp;totalSeats||integer(int32)||
|&emsp;&emsp;availableSeats||integer(int32)||
|&emsp;&emsp;rowCount||integer(int32)||
|&emsp;&emsp;colCount||integer(int32)||
|&emsp;&emsp;layoutConfig||string||
|&emsp;&emsp;openStatus||integer(int32)||
|&emsp;&emsp;openTimeConfig||string||
|&emsp;&emsp;advanceReservationHours||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;facilities||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasWifi||integer(int32)||
|&emsp;&emsp;hasAirConditioner||integer(int32)||
|&emsp;&emsp;hasWater||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;averageRating||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"roomCode": "",
		"roomName": "",
		"building": "",
		"floor": "",
		"location": "",
		"description": "",
		"coverImage": "",
		"layoutImage": "",
		"totalSeats": 0,
		"availableSeats": 0,
		"rowCount": 0,
		"colCount": 0,
		"layoutConfig": "",
		"openStatus": 0,
		"openTimeConfig": "",
		"advanceReservationHours": 0,
		"minReservationMinutes": 0,
		"maxReservationMinutes": 0,
		"facilities": "",
		"hasPower": 0,
		"hasWifi": 0,
		"hasAirConditioner": 0,
		"hasWater": 0,
		"popularityScore": 0,
		"usageCount": 0,
		"averageRating": 0,
		"createTime": "",
		"updateTime": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室列表


**接口地址**:`/api/admin/room/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|request||query|true|RoomQueryRequest|RoomQueryRequest|
|&emsp;&emsp;building|||false|string||
|&emsp;&emsp;floor|||false|string||
|&emsp;&emsp;openStatus|||false|integer(int32)||
|&emsp;&emsp;roomName|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListRoomVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|RoomVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomCode||string||
|&emsp;&emsp;roomName||string||
|&emsp;&emsp;building||string||
|&emsp;&emsp;floor||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;coverImage||string||
|&emsp;&emsp;layoutImage||string||
|&emsp;&emsp;totalSeats||integer(int32)||
|&emsp;&emsp;availableSeats||integer(int32)||
|&emsp;&emsp;rowCount||integer(int32)||
|&emsp;&emsp;colCount||integer(int32)||
|&emsp;&emsp;layoutConfig||string||
|&emsp;&emsp;openStatus||integer(int32)||
|&emsp;&emsp;openTimeConfig||string||
|&emsp;&emsp;advanceReservationHours||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;facilities||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasWifi||integer(int32)||
|&emsp;&emsp;hasAirConditioner||integer(int32)||
|&emsp;&emsp;hasWater||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;averageRating||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomCode": "",
			"roomName": "",
			"building": "",
			"floor": "",
			"location": "",
			"description": "",
			"coverImage": "",
			"layoutImage": "",
			"totalSeats": 0,
			"availableSeats": 0,
			"rowCount": 0,
			"colCount": 0,
			"layoutConfig": "",
			"openStatus": 0,
			"openTimeConfig": "",
			"advanceReservationHours": 0,
			"minReservationMinutes": 0,
			"maxReservationMinutes": 0,
			"facilities": "",
			"hasPower": 0,
			"hasWifi": 0,
			"hasAirConditioner": 0,
			"hasWater": 0,
			"popularityScore": 0,
			"usageCount": 0,
			"averageRating": 0,
			"createTime": "",
			"updateTime": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室状态


**接口地址**:`/api/admin/room/status/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新自习室状态


**接口地址**:`/api/admin/room/status/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|status||query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新自习室


**接口地址**:`/api/admin/room/update/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "roomCode": "",
  "roomName": "",
  "building": "",
  "floor": "",
  "location": "",
  "description": "",
  "coverImage": "",
  "layoutImage": "",
  "totalSeats": 0,
  "rowCount": 0,
  "colCount": 0,
  "layoutConfig": "",
  "openTimeConfig": "",
  "advanceReservationHours": 0,
  "minReservationMinutes": 0,
  "maxReservationMinutes": 0,
  "facilities": "",
  "hasPower": 0,
  "hasWifi": 0,
  "hasAirConditioner": 0,
  "hasWater": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|roomCreateRequest|RoomCreateRequest|body|true|RoomCreateRequest|RoomCreateRequest|
|&emsp;&emsp;roomCode|||false|string||
|&emsp;&emsp;roomName|||false|string||
|&emsp;&emsp;building|||false|string||
|&emsp;&emsp;floor|||false|string||
|&emsp;&emsp;location|||false|string||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;coverImage|||false|string||
|&emsp;&emsp;layoutImage|||false|string||
|&emsp;&emsp;totalSeats|||false|integer(int32)||
|&emsp;&emsp;rowCount|||false|integer(int32)||
|&emsp;&emsp;colCount|||false|integer(int32)||
|&emsp;&emsp;layoutConfig|||false|string||
|&emsp;&emsp;openTimeConfig|||false|string||
|&emsp;&emsp;advanceReservationHours|||false|integer(int32)||
|&emsp;&emsp;minReservationMinutes|||false|integer(int32)||
|&emsp;&emsp;maxReservationMinutes|||false|integer(int32)||
|&emsp;&emsp;facilities|||false|string||
|&emsp;&emsp;hasPower|||false|integer(int32)||
|&emsp;&emsp;hasWifi|||false|integer(int32)||
|&emsp;&emsp;hasAirConditioner|||false|integer(int32)||
|&emsp;&emsp;hasWater|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 自习室接口


## 获取自习室可用座位


**接口地址**:`/api/room/{roomId}/available-seats`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListSeatVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|SeatVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatCode||string||
|&emsp;&emsp;seatNumber||string||
|&emsp;&emsp;seatType||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;currentReservationId||integer(int64)||
|&emsp;&emsp;currentUserId||integer(int64)||
|&emsp;&emsp;rowIndex||integer(int32)||
|&emsp;&emsp;colIndex||integer(int32)||
|&emsp;&emsp;positionX||integer(int32)||
|&emsp;&emsp;positionY||integer(int32)||
|&emsp;&emsp;positionConfig||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasDeskLamp||integer(int32)||
|&emsp;&emsp;isWindowSeat||integer(int32)||
|&emsp;&emsp;isQuietZone||integer(int32)||
|&emsp;&emsp;tags||string||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;lastUsedTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomId": 0,
			"seatCode": "",
			"seatNumber": "",
			"seatType": "",
			"status": "",
			"currentReservationId": 0,
			"currentUserId": 0,
			"rowIndex": 0,
			"colIndex": 0,
			"positionX": 0,
			"positionY": 0,
			"positionConfig": "",
			"hasPower": 0,
			"hasDeskLamp": 0,
			"isWindowSeat": 0,
			"isQuietZone": 0,
			"tags": "",
			"usageCount": 0,
			"popularityScore": 0,
			"lastUsedTime": "",
			"createTime": "",
			"updateTime": "",
			"seatTypeEnum": "",
			"statusEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室统计信息


**接口地址**:`/api/room/{roomId}/seat-statistics`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室座位信息


**接口地址**:`/api/room/{roomId}/seats`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListSeatVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|SeatVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatCode||string||
|&emsp;&emsp;seatNumber||string||
|&emsp;&emsp;seatType||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;currentReservationId||integer(int64)||
|&emsp;&emsp;currentUserId||integer(int64)||
|&emsp;&emsp;rowIndex||integer(int32)||
|&emsp;&emsp;colIndex||integer(int32)||
|&emsp;&emsp;positionX||integer(int32)||
|&emsp;&emsp;positionY||integer(int32)||
|&emsp;&emsp;positionConfig||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasDeskLamp||integer(int32)||
|&emsp;&emsp;isWindowSeat||integer(int32)||
|&emsp;&emsp;isQuietZone||integer(int32)||
|&emsp;&emsp;tags||string||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;lastUsedTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomId": 0,
			"seatCode": "",
			"seatNumber": "",
			"seatType": "",
			"status": "",
			"currentReservationId": 0,
			"currentUserId": 0,
			"rowIndex": 0,
			"colIndex": 0,
			"positionX": 0,
			"positionY": 0,
			"positionConfig": "",
			"hasPower": 0,
			"hasDeskLamp": 0,
			"isWindowSeat": 0,
			"isQuietZone": 0,
			"tags": "",
			"usageCount": 0,
			"popularityScore": 0,
			"lastUsedTime": "",
			"createTime": "",
			"updateTime": "",
			"seatTypeEnum": "",
			"statusEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取可用自习室


**接口地址**:`/api/room/available`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListRoomVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|RoomVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomCode||string||
|&emsp;&emsp;roomName||string||
|&emsp;&emsp;building||string||
|&emsp;&emsp;floor||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;coverImage||string||
|&emsp;&emsp;layoutImage||string||
|&emsp;&emsp;totalSeats||integer(int32)||
|&emsp;&emsp;availableSeats||integer(int32)||
|&emsp;&emsp;rowCount||integer(int32)||
|&emsp;&emsp;colCount||integer(int32)||
|&emsp;&emsp;layoutConfig||string||
|&emsp;&emsp;openStatus||integer(int32)||
|&emsp;&emsp;openTimeConfig||string||
|&emsp;&emsp;advanceReservationHours||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;facilities||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasWifi||integer(int32)||
|&emsp;&emsp;hasAirConditioner||integer(int32)||
|&emsp;&emsp;hasWater||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;averageRating||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomCode": "",
			"roomName": "",
			"building": "",
			"floor": "",
			"location": "",
			"description": "",
			"coverImage": "",
			"layoutImage": "",
			"totalSeats": 0,
			"availableSeats": 0,
			"rowCount": 0,
			"colCount": 0,
			"layoutConfig": "",
			"openStatus": 0,
			"openTimeConfig": "",
			"advanceReservationHours": 0,
			"minReservationMinutes": 0,
			"maxReservationMinutes": 0,
			"facilities": "",
			"hasPower": 0,
			"hasWifi": 0,
			"hasAirConditioner": 0,
			"hasWater": 0,
			"popularityScore": 0,
			"usageCount": 0,
			"averageRating": 0,
			"createTime": "",
			"updateTime": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室详情


**接口地址**:`/api/room/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultRoomVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||RoomVO|RoomVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomCode||string||
|&emsp;&emsp;roomName||string||
|&emsp;&emsp;building||string||
|&emsp;&emsp;floor||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;coverImage||string||
|&emsp;&emsp;layoutImage||string||
|&emsp;&emsp;totalSeats||integer(int32)||
|&emsp;&emsp;availableSeats||integer(int32)||
|&emsp;&emsp;rowCount||integer(int32)||
|&emsp;&emsp;colCount||integer(int32)||
|&emsp;&emsp;layoutConfig||string||
|&emsp;&emsp;openStatus||integer(int32)||
|&emsp;&emsp;openTimeConfig||string||
|&emsp;&emsp;advanceReservationHours||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;facilities||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasWifi||integer(int32)||
|&emsp;&emsp;hasAirConditioner||integer(int32)||
|&emsp;&emsp;hasWater||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;averageRating||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"roomCode": "",
		"roomName": "",
		"building": "",
		"floor": "",
		"location": "",
		"description": "",
		"coverImage": "",
		"layoutImage": "",
		"totalSeats": 0,
		"availableSeats": 0,
		"rowCount": 0,
		"colCount": 0,
		"layoutConfig": "",
		"openStatus": 0,
		"openTimeConfig": "",
		"advanceReservationHours": 0,
		"minReservationMinutes": 0,
		"maxReservationMinutes": 0,
		"facilities": "",
		"hasPower": 0,
		"hasWifi": 0,
		"hasAirConditioner": 0,
		"hasWater": 0,
		"popularityScore": 0,
		"usageCount": 0,
		"averageRating": 0,
		"createTime": "",
		"updateTime": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室列表


**接口地址**:`/api/room/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListRoomVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|RoomVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomCode||string||
|&emsp;&emsp;roomName||string||
|&emsp;&emsp;building||string||
|&emsp;&emsp;floor||string||
|&emsp;&emsp;location||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;coverImage||string||
|&emsp;&emsp;layoutImage||string||
|&emsp;&emsp;totalSeats||integer(int32)||
|&emsp;&emsp;availableSeats||integer(int32)||
|&emsp;&emsp;rowCount||integer(int32)||
|&emsp;&emsp;colCount||integer(int32)||
|&emsp;&emsp;layoutConfig||string||
|&emsp;&emsp;openStatus||integer(int32)||
|&emsp;&emsp;openTimeConfig||string||
|&emsp;&emsp;advanceReservationHours||integer(int32)||
|&emsp;&emsp;minReservationMinutes||integer(int32)||
|&emsp;&emsp;maxReservationMinutes||integer(int32)||
|&emsp;&emsp;facilities||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasWifi||integer(int32)||
|&emsp;&emsp;hasAirConditioner||integer(int32)||
|&emsp;&emsp;hasWater||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;averageRating||number||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomCode": "",
			"roomName": "",
			"building": "",
			"floor": "",
			"location": "",
			"description": "",
			"coverImage": "",
			"layoutImage": "",
			"totalSeats": 0,
			"availableSeats": 0,
			"rowCount": 0,
			"colCount": 0,
			"layoutConfig": "",
			"openStatus": 0,
			"openTimeConfig": "",
			"advanceReservationHours": 0,
			"minReservationMinutes": 0,
			"maxReservationMinutes": 0,
			"facilities": "",
			"hasPower": 0,
			"hasWifi": 0,
			"hasAirConditioner": 0,
			"hasWater": 0,
			"popularityScore": 0,
			"usageCount": 0,
			"averageRating": 0,
			"createTime": "",
			"updateTime": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室状态


**接口地址**:`/api/room/status/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


# 座位接口


## 获取某自习室内可用座位


**接口地址**:`/api/api/admin/seat/available/{roomId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListSeatVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|SeatVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatCode||string||
|&emsp;&emsp;seatNumber||string||
|&emsp;&emsp;seatType||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;currentReservationId||integer(int64)||
|&emsp;&emsp;currentUserId||integer(int64)||
|&emsp;&emsp;rowIndex||integer(int32)||
|&emsp;&emsp;colIndex||integer(int32)||
|&emsp;&emsp;positionX||integer(int32)||
|&emsp;&emsp;positionY||integer(int32)||
|&emsp;&emsp;positionConfig||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasDeskLamp||integer(int32)||
|&emsp;&emsp;isWindowSeat||integer(int32)||
|&emsp;&emsp;isQuietZone||integer(int32)||
|&emsp;&emsp;tags||string||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;lastUsedTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomId": 0,
			"seatCode": "",
			"seatNumber": "",
			"seatType": "",
			"status": "",
			"currentReservationId": 0,
			"currentUserId": 0,
			"rowIndex": 0,
			"colIndex": 0,
			"positionX": 0,
			"positionY": 0,
			"positionConfig": "",
			"hasPower": 0,
			"hasDeskLamp": 0,
			"isWindowSeat": 0,
			"isQuietZone": 0,
			"tags": "",
			"usageCount": 0,
			"popularityScore": 0,
			"lastUsedTime": "",
			"createTime": "",
			"updateTime": "",
			"seatTypeEnum": "",
			"statusEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 批量创建座位


**接口地址**:`/api/api/admin/seat/batch-create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
[
  {
    "id": 0,
    "roomId": 0,
    "seatCode": "",
    "seatNumber": "",
    "seatType": "",
    "status": "",
    "currentReservationId": 0,
    "currentUserId": 0,
    "rowIndex": 0,
    "colIndex": 0,
    "positionX": 0,
    "positionY": 0,
    "positionConfig": "",
    "hasPower": 0,
    "hasDeskLamp": 0,
    "isWindowSeat": 0,
    "isQuietZone": 0,
    "tags": "",
    "usageCount": 0,
    "popularityScore": 0,
    "lastUsedTime": "",
    "createTime": "",
    "updateTime": "",
    "createBy": 0,
    "updateBy": 0,
    "deleted": 0,
    "seatTypeEnum": "",
    "statusEnum": ""
  }
]
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|seats|Seat|body|true|array|Seat|
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatCode|||false|string||
|&emsp;&emsp;seatNumber|||false|string||
|&emsp;&emsp;seatType|||false|string||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;currentReservationId|||false|integer(int64)||
|&emsp;&emsp;currentUserId|||false|integer(int64)||
|&emsp;&emsp;rowIndex|||false|integer(int32)||
|&emsp;&emsp;colIndex|||false|integer(int32)||
|&emsp;&emsp;positionX|||false|integer(int32)||
|&emsp;&emsp;positionY|||false|integer(int32)||
|&emsp;&emsp;positionConfig|||false|string||
|&emsp;&emsp;hasPower|||false|integer(int32)||
|&emsp;&emsp;hasDeskLamp|||false|integer(int32)||
|&emsp;&emsp;isWindowSeat|||false|integer(int32)||
|&emsp;&emsp;isQuietZone|||false|integer(int32)||
|&emsp;&emsp;tags|||false|string||
|&emsp;&emsp;usageCount|||false|integer(int32)||
|&emsp;&emsp;popularityScore|||false|integer(int32)||
|&emsp;&emsp;lastUsedTime|||false|string(date-time)||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;createBy|||false|integer(int64)||
|&emsp;&emsp;updateBy|||false|integer(int64)||
|&emsp;&emsp;deleted|||false|integer(int32)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW||false|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 创建座位


**接口地址**:`/api/api/admin/seat/create`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "id": 0,
  "roomId": 0,
  "seatCode": "",
  "seatNumber": "",
  "seatType": "",
  "status": "",
  "currentReservationId": 0,
  "currentUserId": 0,
  "rowIndex": 0,
  "colIndex": 0,
  "positionX": 0,
  "positionY": 0,
  "positionConfig": "",
  "hasPower": 0,
  "hasDeskLamp": 0,
  "isWindowSeat": 0,
  "isQuietZone": 0,
  "tags": "",
  "usageCount": 0,
  "popularityScore": 0,
  "lastUsedTime": "",
  "createTime": "",
  "updateTime": "",
  "createBy": 0,
  "updateBy": 0,
  "deleted": 0,
  "seatTypeEnum": "",
  "statusEnum": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|seat|Seat|body|true|Seat|Seat|
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatCode|||false|string||
|&emsp;&emsp;seatNumber|||false|string||
|&emsp;&emsp;seatType|||false|string||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;currentReservationId|||false|integer(int64)||
|&emsp;&emsp;currentUserId|||false|integer(int64)||
|&emsp;&emsp;rowIndex|||false|integer(int32)||
|&emsp;&emsp;colIndex|||false|integer(int32)||
|&emsp;&emsp;positionX|||false|integer(int32)||
|&emsp;&emsp;positionY|||false|integer(int32)||
|&emsp;&emsp;positionConfig|||false|string||
|&emsp;&emsp;hasPower|||false|integer(int32)||
|&emsp;&emsp;hasDeskLamp|||false|integer(int32)||
|&emsp;&emsp;isWindowSeat|||false|integer(int32)||
|&emsp;&emsp;isQuietZone|||false|integer(int32)||
|&emsp;&emsp;tags|||false|string||
|&emsp;&emsp;usageCount|||false|integer(int32)||
|&emsp;&emsp;popularityScore|||false|integer(int32)||
|&emsp;&emsp;lastUsedTime|||false|string(date-time)||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;createBy|||false|integer(int64)||
|&emsp;&emsp;updateBy|||false|integer(int64)||
|&emsp;&emsp;deleted|||false|integer(int32)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW||false|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 删除座位


**接口地址**:`/api/api/admin/seat/delete/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取座位信息


**接口地址**:`/api/api/admin/seat/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultSeatVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||SeatVO|SeatVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatCode||string||
|&emsp;&emsp;seatNumber||string||
|&emsp;&emsp;seatType||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;currentReservationId||integer(int64)||
|&emsp;&emsp;currentUserId||integer(int64)||
|&emsp;&emsp;rowIndex||integer(int32)||
|&emsp;&emsp;colIndex||integer(int32)||
|&emsp;&emsp;positionX||integer(int32)||
|&emsp;&emsp;positionY||integer(int32)||
|&emsp;&emsp;positionConfig||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasDeskLamp||integer(int32)||
|&emsp;&emsp;isWindowSeat||integer(int32)||
|&emsp;&emsp;isQuietZone||integer(int32)||
|&emsp;&emsp;tags||string||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;lastUsedTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"roomId": 0,
		"seatCode": "",
		"seatNumber": "",
		"seatType": "",
		"status": "",
		"currentReservationId": 0,
		"currentUserId": 0,
		"rowIndex": 0,
		"colIndex": 0,
		"positionX": 0,
		"positionY": 0,
		"positionConfig": "",
		"hasPower": 0,
		"hasDeskLamp": 0,
		"isWindowSeat": 0,
		"isQuietZone": 0,
		"tags": "",
		"usageCount": 0,
		"popularityScore": 0,
		"lastUsedTime": "",
		"createTime": "",
		"updateTime": "",
		"seatTypeEnum": "",
		"statusEnum": ""
	},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 导入座位


**接口地址**:`/api/api/admin/seat/import`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "roomId": 0,
  "rowCount": 0,
  "colCount": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|seatImportRequest|SeatImportRequest|body|true|SeatImportRequest|SeatImportRequest|
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;rowCount|||false|integer(int32)||
|&emsp;&emsp;colCount|||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新座位布局


**接口地址**:`/api/api/admin/seat/layout`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "roomId": 0,
  "layoutConfig": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|seatLayoutUpdateRequest|SeatLayoutUpdateRequest|body|true|SeatLayoutUpdateRequest|SeatLayoutUpdateRequest|
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;layoutConfig|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取座位布局


**接口地址**:`/api/api/admin/seat/layout/{roomId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 根据自习室id获取座位列表


**接口地址**:`/api/api/admin/seat/list/{roomId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListSeatVO|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||array|SeatVO|
|&emsp;&emsp;id||integer(int64)||
|&emsp;&emsp;roomId||integer(int64)||
|&emsp;&emsp;seatCode||string||
|&emsp;&emsp;seatNumber||string||
|&emsp;&emsp;seatType||string||
|&emsp;&emsp;status||string||
|&emsp;&emsp;currentReservationId||integer(int64)||
|&emsp;&emsp;currentUserId||integer(int64)||
|&emsp;&emsp;rowIndex||integer(int32)||
|&emsp;&emsp;colIndex||integer(int32)||
|&emsp;&emsp;positionX||integer(int32)||
|&emsp;&emsp;positionY||integer(int32)||
|&emsp;&emsp;positionConfig||string||
|&emsp;&emsp;hasPower||integer(int32)||
|&emsp;&emsp;hasDeskLamp||integer(int32)||
|&emsp;&emsp;isWindowSeat||integer(int32)||
|&emsp;&emsp;isQuietZone||integer(int32)||
|&emsp;&emsp;tags||string||
|&emsp;&emsp;usageCount||integer(int32)||
|&emsp;&emsp;popularityScore||integer(int32)||
|&emsp;&emsp;lastUsedTime||string(date-time)||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE|string||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"roomId": 0,
			"seatCode": "",
			"seatNumber": "",
			"seatType": "",
			"status": "",
			"currentReservationId": 0,
			"currentUserId": 0,
			"rowIndex": 0,
			"colIndex": 0,
			"positionX": 0,
			"positionY": 0,
			"positionConfig": "",
			"hasPower": 0,
			"hasDeskLamp": 0,
			"isWindowSeat": 0,
			"isQuietZone": 0,
			"tags": "",
			"usageCount": 0,
			"popularityScore": 0,
			"lastUsedTime": "",
			"createTime": "",
			"updateTime": "",
			"seatTypeEnum": "",
			"statusEnum": ""
		}
	],
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 占座


**接口地址**:`/api/api/admin/seat/occupy/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|userId||query|true|integer(int64)||
|reservationId||query|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 释放座位


**接口地址**:`/api/api/admin/seat/release/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 获取自习室内座位统计信息


**接口地址**:`/api/api/admin/seat/statistics/{roomId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|roomId||path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultMapStringObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新座位信息


**接口地址**:`/api/api/admin/seat/status/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|status||query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


## 更新座位


**接口地址**:`/api/api/admin/seat/update/{id}`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "id": 0,
  "roomId": 0,
  "seatCode": "",
  "seatNumber": "",
  "seatType": "",
  "status": "",
  "currentReservationId": 0,
  "currentUserId": 0,
  "rowIndex": 0,
  "colIndex": 0,
  "positionX": 0,
  "positionY": 0,
  "positionConfig": "",
  "hasPower": 0,
  "hasDeskLamp": 0,
  "isWindowSeat": 0,
  "isQuietZone": 0,
  "tags": "",
  "usageCount": 0,
  "popularityScore": 0,
  "lastUsedTime": "",
  "createTime": "",
  "updateTime": "",
  "createBy": 0,
  "updateBy": 0,
  "deleted": 0,
  "seatTypeEnum": "",
  "statusEnum": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id||path|true|integer(int64)||
|seat|Seat|body|true|Seat|Seat|
|&emsp;&emsp;id|||false|integer(int64)||
|&emsp;&emsp;roomId|||false|integer(int64)||
|&emsp;&emsp;seatCode|||false|string||
|&emsp;&emsp;seatNumber|||false|string||
|&emsp;&emsp;seatType|||false|string||
|&emsp;&emsp;status|||false|string||
|&emsp;&emsp;currentReservationId|||false|integer(int64)||
|&emsp;&emsp;currentUserId|||false|integer(int64)||
|&emsp;&emsp;rowIndex|||false|integer(int32)||
|&emsp;&emsp;colIndex|||false|integer(int32)||
|&emsp;&emsp;positionX|||false|integer(int32)||
|&emsp;&emsp;positionY|||false|integer(int32)||
|&emsp;&emsp;positionConfig|||false|string||
|&emsp;&emsp;hasPower|||false|integer(int32)||
|&emsp;&emsp;hasDeskLamp|||false|integer(int32)||
|&emsp;&emsp;isWindowSeat|||false|integer(int32)||
|&emsp;&emsp;isQuietZone|||false|integer(int32)||
|&emsp;&emsp;tags|||false|string||
|&emsp;&emsp;usageCount|||false|integer(int32)||
|&emsp;&emsp;popularityScore|||false|integer(int32)||
|&emsp;&emsp;lastUsedTime|||false|string(date-time)||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|&emsp;&emsp;createBy|||false|integer(int64)||
|&emsp;&emsp;updateBy|||false|integer(int64)||
|&emsp;&emsp;deleted|||false|integer(int32)||
|&emsp;&emsp;seatTypeEnum|可用值:NORMAL,VIP,DISABLED,STANDING,GROUP,WINDOW||false|string||
|&emsp;&emsp;statusEnum|可用值:AVAILABLE,RESERVED,IN_USE,TEMPORARY_LEAVE,MAINTENANCE,UNAVAILABLE||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultObject|
|404|Not Found|ResultVoid|


**响应状态码-200**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```


**响应状态码-404**:


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|message||string||
|data||object||
|timestamp||integer(int64)|integer(int64)|
|success||boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {},
	"timestamp": 0,
	"success": true
}
```
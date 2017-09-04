/**
 * Created by Administrator on 2017/8/14.
 */
package com.dai7;


/**
 * 项目主要分为  mapper（dao）  service  biz  com.dai7.controller 层
 *
 * 每一层各司其职，不要违反依赖倒置原则，尽量保证以下几点：
 *
  domain 不能有默认值；不要使用基本类型，不要使setter/getter 方法有任何业务代码。model仅仅是model（参见阿里代码手册）

  mapper（dao）层，保证每个方法只做一件事情，sql只做单表查询，并且只被本model的 service调用，查询必须走索引，不使用【非】逻辑

  service 之间不要相互调用，保证每个service 是一个独立的功能单元，且有接口，实现类本身包级私有
  由于dao层大部分情况下没有实现类，所以service层需要一些log和 pre dao的参数验证。

  facade包下 不需要有相应模块子包，一个biz只能调用本模块的 service， 但是 biz 之间任意调用

  Controller 层开发阶段可以写业务，但最好把相应的业务 移植进一个 biz，以保证controller 只做 IO，单一职责



 对于各层使用的model类：
 应保证VO 只在controller层使用，不要下溢到 service。例如 errResult类是IO层协议外皮，不应让service返回
 domain 可以在各层使用，
 基本类型可以用在方法参数 和局部变量，不用在 domain 或者 VO DTO 等参数/返回值 的类的默认值上
 service 参数个数最好不超过6个，上限10个，超过10个一定要提取成为一个单独的类，例如 ：MyEncourageDTO这种名字的类


 关于常量： 不允许在代码中直接使用  0；1 “huifu” 这种魔法数字，会使业务难以维护，类似常量必须 添加全局唯一引用常量，然后在各代码处使用


 FIXME wanring 规范可能在项目初期，并没有什么卵用，不要反感，随着业务的增加，新需求的积累，重构的过度，带来的好处是显而易见的

 */
# mybatis 该项目 作为mybatis 演示

在intellij 中对分支打tag操作。

1.为什么要打tag？

tag中文的意思是标签的意思，生活中的标签有很多，比如产品的合格标签，赠品标签。 而在开发过程中，可能会有这样的问题出现，1 一个版本开发结束后，进行分支合并，在master上进行测试 上线，上线后发现有问题需要急需退回到上一个版本，这就要求我们自己手动在服务器上备份很多的war或者备份很多的文件夹。2 如果一般的修改在没有拉取新分支，而是在master上直接修改的话，修改后上线有问题，可以及时的拉取退回。3 如果在发版的时候忘记了备份war或者备份文件夹，及时代码进行回滚，代码回滚会造成一部分提交无效。所以，打tag很必要。

2.git tag和git branches区别？

tag就像里程碑标志的一个点，branch是一个新的征程的一条线；tag 是静态的，而branch要往前走；稳定版本备份用tag，新功能开发多人用branch，开发完之后再merge到master上。 tag是一个只读的branch。
mybatis 测试示例代码 自己学习使用

mybatis 测试示例代码 自己学习使用

1.tag1 ： 项目初始 tag-name =v1.0

2.tag2 ： 搭建环境并测试 tag-name =v1.1

3.tag3 ： 使用Mapper接口方式，完成单表CRUD操作 tag-name = v1.2

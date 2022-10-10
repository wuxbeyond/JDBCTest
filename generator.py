"""
Generator 是一个用于创建迭代器的简单而强大的工具。 它们的写法类似标准的函数，但当它们要返回数据时会使用 yield 语句。
 每次对生成器调用 next() 时，它会从上次离开位置恢复执行（它会记住上次执行语句时的所有数据值）
 可以用生成器来完成的操作同样可以用前一节所描述的基于类的迭代器来完成。 
 但生成器的写法更为紧凑，因为它会自动创建 __iter__() 和 __next__() 方法。
"""


def reverse(data):
    for index in range(len(data) - 1, -1, -1):
        yield data[index]


for char in reverse("123456"):
    print(char)

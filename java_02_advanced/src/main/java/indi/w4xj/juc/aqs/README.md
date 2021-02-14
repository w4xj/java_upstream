#### 谈到并发，不得不谈ReentrantLock；而谈到ReentrantLock，它依赖于AbstractQueuedSynchronizer（AQS）！抽象的队列式的同步器，AQS定义了一套多线程访问共享资源的同步器框架，许多同步类实现都依赖于它，如常用的ReentrantLock/Semaphore/CountDownLatch...
## 1.CountDownLatch
### [1].让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒
### [2].CountDownLatch主要有2个方法
    countDown():计数器减一
    await()：到此处线程阻塞，当计数器变成0后，被唤醒
### [3].代码示例
#### [CountDownLatch示例](./code/CountDownLatchTest.java)
## 2.CyclicBarrier
### [1].与CountDownLatch相反，当计数器加到某个值时，继续执行
### [2].方法
#### ①.构造方法 public CyclicBarrier(int parties, Runnable barrierAction)
#### ②.await()：先到先阻塞
### [3].代码示例
#### [CyclicBarrier示例](./code/CyclicBarrierTest.java)
## 3.Semaphore
### [1].信号灯主要用于2个目的，一个是用于多个共享资源的互斥使用，另一个是用于并发线程数的控制
### [2].方法
#### acquire()：抢到资源
#### release()：释放资源
### [3].代码示例
[Semaphore示例](./code/SemaphoreTest.java)
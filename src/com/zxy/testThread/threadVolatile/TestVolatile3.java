package com.zxy.testThread.threadVolatile;

public   class  TestVolatile3 {      
	 boolean  boolValue;
    /**      
     * 成员变量boolValue使用volatile和不使用volatile会有明显区别的。     
     * 本程序需要多试几次，就能知道两者之间的区别的。     
     * @param args     
     */      
    public   static   void  main(String[] args) {      
        final  TestVolatile3 volObj= new  TestVolatile3();      
        Thread t1=new  Thread(){      
            @Override
			public   void  run(){      
                System.out.println("t1 start" );      
                for (;;){      
                        volObj.waitToExit();
                }      
            }      
        };      
        t1.start();      
        Thread t2=new  Thread(){      
            @Override
			public   void  run(){      
                System.out.println("t2 start" );      
                for (;;){      
                    volObj.swap();      
                }      
            }      
        };      
        t2.start();      
    }    
    public   void  waitToExit() {      
        if (boolValue == !boolValue)System.exit( 0 ); //非原子操作，理论上应该很快会被打断。实际不是，因为此时的boolValue在线程自己内部的工作内存的拷贝，因为它不会强制和主存区域同步，线程2修改了boolValue很少有机会传递到线程一的工作内存中。所以照成了假的“原子现象”。       
    }      
          
    public   void  swap() { //不断反复修改boolValue，以期打断线程t1.       
        boolValue = !boolValue;      
    }      
}
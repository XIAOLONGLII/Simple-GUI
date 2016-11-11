//Classmate gave me some hints to finish this. Still I don't think it is perfect.
//I have buffer class, with its constructor. runSimulation() can run consumer and producer shared buffer. 
//Then I have two producers, two consumers, wrote then down without loop, since I don't know how to write a loop also the projext needs 2 producers and 2 consumers.
//class ProConItm was hard for me to build. 
//producerItem() and consumeItem() wasn't that hard since we have codes from class slides of PPT.
//main() from Mimir's test case! 


import java.util.LinkedList;
import java.time.LocalDateTime;


	public class Buffer
	{
		
		static int SizeBuffer;
		int numOfProducer;
		int numOfConsumer;
		static int ProducerSleep;
		static int ConsumerSleep;
		int nOfProRun;
		
		
		public Buffer(int SizeBuffer, int numOfProducer, int numOfConsumer, int ProducerSleep, int ConsumerSleep, int nOfProRun)
		{
			Buffer.SizeBuffer = SizeBuffer;
			this.numOfProducer = numOfProducer;
			this.numOfConsumer = numOfConsumer;
			Buffer.ProducerSleep = ProducerSleep;
			Buffer.ConsumerSleep = ConsumerSleep;
			this.nOfProRun = nOfProRun;
		}
		
		
		
			
			public void runSimulation() throws InterruptedException
			{
				final ProConItm items = new ProConItm();
			
			
			Thread t1 = new Thread("P1")
			{
				public void run()
				{
					try
					{
						items.produceItem();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};
			
			Thread t2 = new Thread("P2")
			{
				public void run()
				{
					try
					{
						items.produceItem();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};

			// Create consumer thread
			Thread t3 = new Thread("C1")
			{
				public void run()
				{
					try
					{
						items.consumeItem();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};
			
			Thread t4 = new Thread("C2")
			{
				public void run()
				{
					try
					{
						items.consumeItem();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			};

			t1.start();
			t2.start();
			t3.start();
			t4.start();

			t1.join();
			t2.join();
			t3.join();
			t4.join();
	
	     
		}

		public static class ProConItm
		{
			// Create a list shared by producer and consumer
			// Size of list is 2.
			LinkedList<LocalDateTime> Buffer = new LinkedList<>();			
			//private String name;

			public void produceItem() throws InterruptedException  // Function called by producer thread
			{

				while (true)
				{ 
					synchronized (this)
					{
						while (Buffer.size()==SizeBuffer) // While buffer is full, producer waits
						wait();
						LocalDateTime value = LocalDateTime.now();

						Buffer.add(value); // Add the jobs in the buffer
						System.out.println("Producer " + Thread.currentThread().getName() + " produced time stamp "
													+ value +"." + " The queue has " + Buffer.size() + " elements");

						
						notify();  // notifies the consumer thread that now it can start consuming
						
						Thread.sleep(ProducerSleep); //put the producer to a sleep
					 } 
					
				}
			 }
			
			public void consumeItem() throws InterruptedException   // Function called by consumer thread
			 {
				 while (true)
				 {
					 synchronized (this)
					 {
						 while (Buffer.size()==0)  //While buffer is empty, consumer thread has waits 
							 wait();
						 	 LocalDateTime val = Buffer.removeFirst(); //to retrieve the first job in the buffer

						 	 System.out.println("Comsumer " + Thread.currentThread().getName() + " got message "
														+ val + "." + " The queue has " + Buffer.size() + " elements");

						 	 notify(); // Wake up producer thread

						 	 Thread.sleep(ConsumerSleep); //put the consumer to sleep while producer is awake
					 }
				
				 }
			 }
		}
		
		public static void main(String[] args) throws InterruptedException
		{
			Buffer te = new Buffer(5, 1, 2, 1000, 1200, 10);
			te.runSimulation();
		
		}
	}


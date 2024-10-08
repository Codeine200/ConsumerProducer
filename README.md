# Producer-Consumer Problem
The producer-consumer problem is a synchronization problem between different processes.
The producer produces some items and pushes them into the memory buffer. A consumer consumes these items.
The memory buffer is of fixed size.
If it is full, the producer waits for the consumer to consume an item before pushing a new one.
The producer and consumer cannot access the buffer at the same time.
We can have different amount of producers and consumers. Each of them runs in a separate thread
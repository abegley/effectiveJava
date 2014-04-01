Item 66:  Synchronize access to shared mutable data

The best way to avoid the problems discussed in this item is not to share mutable data. Either share immutable data(see item 15)
or don't share at all.

 In summary,

 1. CONFINE MUTABLE DATA TO A SINGLE THREAD

 2. WHEN MULTIPLE THREADS SHARE MUTABLE DATA, EACH THREAD THAT READS OR WRITES THE DATA MUST PERFORM SYNCHRONIZATION

 Without synchronization, there is no guarantee that one thread's changes will be visible to another.  The penalties
 for failing to synchronize shared mutable data are liveness and safety failures.

 If you need only inter-thread communication, and not mutual exclusion, the volatile modifier is an acceptable form of
 synchronization, but it can be tricky to use (see Notes section in StopThreadVolatile.java)
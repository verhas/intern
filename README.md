intern
======

This library implements the `InternPool` as described on the page
[javax0 article](http://javax0.wordpress.com/2014/03/11/object-interning/). It is capable interning objects.
Interned objects in a pool are represented with a single instance when they are equal. Thus

```
   a = pool.intern(a)
   b = pool.intern(b)
```

will become `a == b` if `a.equals(b)` was true before interning even if `a == b` was not true before interning.

The library is thread safe.

```
<dependency>
  <groupId>com.javax0</groupId>
  <artifactId>intern</artifactId>
  <version>1.0.0</version>
</dependency>
```

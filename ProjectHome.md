# Java Dev Tools #

Includes:
  * Misc Dev Tools
  * Design Patterns
  * MySQL Query by Method Chaining

## Design Patterns ##
  * Observer
  * Factory
  * Command
  * State
  * Memento

### Observer Pattern ###
  * State Context is Observable
  * State Changed is Notitification

### Command Pattern ###
  * Command is State Context

## MySQL Query by Method Chaining ##
### Select Example ###
To produce statement
```
SELECT * FROM customers WHERE age BETEWEEN 3 AND 10 ORDER BY id;
```


```
Customers.instance()
    .selectAll()
    .where(Between.test(Customers.age(), 3, 10))
    .orderBy(Customers.id())
```
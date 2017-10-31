# NeoComponentsAutoLoad

Simple autoloading API using fast-classpath-scanner

The autoloader will only load classes that can be instantiated.

## Usage

```java
package com.example.modules;

public interface ModuleAutoLoadDescriptor implements AutoLoadDescriptor<Module> {
  public Class<Module> getTargetClass() {
    return Module.class;
  }
}
```

```java
AutoLoadService.load(new ModuleAutoLoadDescriptor(), moduleClass -> { moduleList.add(moduleClass.newInstance()) });
```

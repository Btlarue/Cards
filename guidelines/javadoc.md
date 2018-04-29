# Javadoc Guidelines

## General
* A javadoc comment must precede a class, field, constructor, or method declaration.
* Separate the paragraphs with a &lt;p&gt; tag.
* Insert a blank comment line between the description and the list of tags.
* The first line that begins with an "@" character ends the description.
* Limit any javadoc comment lines to 80 characters.
* The first sentence of a comment should be a concise and complete sentence.
* Complete each sentence with a period.


## Style Guide
* Use &lt;code&gt; tags for java keywords (class, package, method, interface, fields, arguments).
* Only use {@link} for first occurrence of API name in the comment or if you feel it is important.
* It is ok to use phrases instead of complete sentences, in the interest of brevity
* Use 3<sup>rd</sup> person not 2<sup>nd</sup> person.
* Avoid latin abbreviations. Use "also know as" instead of a.k.a..


## Conventions
### Order of Tags
1. @author - classes and interfaces only, required
2. @version - classes and interfaces only, required
3. @param - methods and constructors only
4. @return - methods only
5. @exception - methods only, @throws is a synonym
6. @see
7. @since
8. @serial
9. @deprecated

### Multiple Tags
* Groups of similar tags can be separated by a blank line with a single asterisk.
* @author tags should be listed in chronological order, with the creator of the class first.
* @param tags should be listed in argument-declaration order. Makes it easier to match.
* @throws tags should be listed alphabetically by the exception name.
* @see tags should be ordered from least-qualified to fully-qualified.

## Classes

## Interfaces

## Enums

## Methods
* Write the first sentence as a short summary of the method.
* Write summary sentences that distinguish overloaded methods from each other.
* Begin documenting from the top of inheritance, Javadoc will copy to overriding methods.
* Begin method descriptions with a verb phrase.
* A @param tag is required for every parameter.
* A @return tag is required for every method that returns something other than void.

Method in the same class
{@link #myMethod(String)}

Method in a different class, same package or imported
{@link MyOtherClass#myMethod(String)}

Method in a different package, not imported
{@link com.mypackage.YetAnotherClass#myMethod(String)}

Label linked to method, in plain text rather than code font
{@linkplain #myMethod(string)}



## Instance Variables
<pre>
// Brief Explanation (preferably all containd on one line).</pre>

## Links / References
[Javadoc](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)
# CS320 Portfolio

This is work that was done for the CS320 Software Testing and Quality Assurance
course at SNHU. The two articles are the mobile application which we developed
and the summary and reflections report.

## Questions from the rubric
We were asked to reflect on and answer the following questions:
- [How can I ensure that my code, program, or software is functional and secure?](#ensuring_functionality_and_security)
- [How do I interpret user needs and incorporate them into a program?](#interpreting_requirements)
- [How do I approach designing software?](#my_approach)

### Ensuring functionality and security
This is a complex question, because there is no one "silver bullet" which will
ensure that everything works correctly and securely. Rather, writing quality software
requires a holistic approach which integrates good practice, avoidance of common
anti-patterns, testing, and code review.

The largest focus of this course was writing unit tests, which we did using the
JUnit framework. I have written unit tests before in several contexts. A few of my
own past projects were written in Zig or in Rust, and both languages have built in
unit testing frameworks in their official toolchains. I have also contributed to
open source projects in both of those languages which required adding test coverage
for the features which I worked on. So I was familiar with unit testing prior to
this course. I found JUnit to be for the most part exactly what I would expect
from such tooling, and in fact was fairly impressed with the workflow. Adding a
test case in Eclipse brought up a dialog which allowed me to add the JUnit framework
directly from the IDE, so setup was a breeze. In fact the only major functional
difference that I saw was that JUnit is not included in the Java language's official
toolkit.

I tend to strive for a test-driven development workflow, but like many other developers
I also tend to fall short of the ideal of a purely TDD workflow. Like many developers
I like to see as high of a percentage as possible in the coverage charts, but I also
realize that the coverage charts do not tell the entire story.

In a previous course we also used the OWASP Dependency Check plugin to do a security
audit on the project's dependency tree. I do find this helpful, but I also like to
be proactive about eliminating or just not taking dependencies to begin with, unless
it is for a piece of code that I don't trust myself to write such as encryption
primitives. Dependency scans are useful, but I think you can set yourself apart from
a lot of software developers today just by being more conservative about dependencies
in the first place.

### Interpreting requirements
I have a tendency to over-engineer solutions sometimes. In a previous school project
written in C++, we were asked to write our own HashMap. Because the length of the
string used for the key was always the same, and known ahead of time, I made that
piece of data a union which could be interpreted as a four-character ASCII string
or as a 32-bit integer. There was no need to convert the key to an integer before
hashing, instead you just read the data as if it was already an int. My professor
wasn't impressed with my cleverness. It was over-engineered. He pointed out that
platform differences could cause it to be interpreted as a different number. I
countered that didn't actually matter, because all we really care about is that it
always resolves to the same number *on the machine the code is running on*, not that
it would resolve to the same number on a different machine. But I lost points, and
I see his point.

That experience taught me to not overthink requirements. For this assignment, I
purposely erred on the side of simplicity rather than looking for the most optimized
solution possible. As an example, we were required to create unique object ID strings.
I used the simplest approach I could think of and just used sequential numbering
converted to string form. It meets the requirements, but does not exceed the performance
expected or attempt anything clever.

Beyond that, unit testing is written with the requirements in mind when doing TDD,
so the unit tests serve as blueprint, tests, and documentation all at once.

### My approach
I tend to write my function signatures first, before writing my tests. That way
I can have a bit of a skeleton in place and think about what tests I am going to
have to write. I'll switch back and forth between whether I am writing the function
body or the tests for that function first, but I tend to write a function and its
associated test(s) before moving on to the next function. Like I said, TDD is the
ideal, but not always the reality.

I also like doing it this way because it allows me to think about potential edge
cases and side-effects while the function or method is still fresh in my mind.
If you follow the ideal and write all unit tests first, I think you could easily
just not even think about the edge cases. It is important to test not only the
"happy path" but to be sure that given erroneous inputs the correct type of
exception is actually thrown. It's also important to plan for the eventuality
that if you ask someone to enter a number, someone will type in "blue". Any good
piece of software must be able to gracefully handle such nonsense inputs.

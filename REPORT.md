# Lab 1 Git Race -- Project Report

## Description of Changes
[Detailed description of all changes made]
### Time-based greeting
Modify the greeting message based on the time of day. <br>

| **Greeting**       | **Time**          |
|----------------|---------------| 
| Good morning   | 05:00 - 11:59 |
| Good afternoon | 12:00 - 17:59 |
| Good evening   | 18:00 - 20:59 |
| Good night     | 21:00 - 04:59 |

In order to do this change, the file _HelloController.kt_ has been modified.
The following helper method has been added:
``` kotlin
    private fun getTimeGreeting(): String {
        val time = LocalTime.now().hour
        var greeting = ""

        if (time in 5..11) {
            greeting = "Good morning"
        } else if (time in 12..17) {
            greeting = "Good afternoon"
        } else if (time in 18..20) {
            greeting = "Good evening"
        } else {
            greeting = "Good night"
        }
        return greeting
    }
```

## Technical Decisions
[Explanation of technical choices made]

## Learning Outcomes
[What you learned from this assignment]



## AI Disclosure
### AI Tools Used
- [List specific AI tools used]

### AI-Assisted Work
- [Describe what was generated with AI assistance]
- [Percentage of AI-assisted vs. original work]
- [Any modifications made to AI-generated code]

### Original Work
- [Describe work done without AI assistance]
- [Your understanding and learning process]


## Bibliography 
- Markdown guide in order to understand how its syntax works.
  - https://www.markdownguide.org/
- 
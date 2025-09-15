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

### User preferences
Store user preferences in local storage. <br>
The first variable saved is the user's name, as entered in the home page.
To implement this, the following line has been added to the ``testApiBtn`` event listener.
``` js
    //Save name in Local Storage
    localStorage.setItem("name", name)
```




## Technical Decisions
[Explanation of technical choices made]
### User preferences
Benefits of storing user preferences in local storage:
- Data remains even after the browser is closed.
- Simple API for storing and accessing data.
- Works for the same source across several tabs in the browser.

## Learning Outcomes
[What you learned from this assignment]



## AI Disclosure
### AI Tools Used
[List specific AI tools used]
- DeepSeek
- ChatGPT
- Grammarly

### AI-Assisted Work
[Describe what was generated with AI assistance]<br>
[Percentage of AI-assisted vs. original work]<br>
[Any modifications made to AI-generated code]<br>
**GENERAL MATTERS**
- Generate an ordered list of the functionality, based on their difficulty. This helped me decide which functionalities I wanted to implement first.
- Rewrite some of the explanations, in order to increase its clarity.

**THEME CUSTOMISATION**
- Little bugs fix (e.g. route bugs).

**MULTI-LANGUAGE SUPPORT**
- What is i18n, how to install it, how to solve installation errors.

### Original Work
- [Describe work done without AI assistance]
- [Your understanding and learning process]


## Bibliography 
- Markdown guide in order to understand how its syntax works.
  - https://www.markdownguide.org/
- How to use Local Storage in JavaScript
  - https://staticmania.com/blog/how-to-use-local-storage-in-javascript
- 
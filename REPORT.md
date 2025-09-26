# Lab 1 Git Race -- Project Report
**Author:** Nerea Salamero Labara<br>
**Date:** September 2025<br>
**Subject:** Web Engineering<br>


## Description of Changes
This section contains a detailed explanation of all modifications made during Lab 1.
### Time-based greeting
The greeting message changes depending on the time of day:

| **Greeting**   | **Time range** |
|----------------|----------------| 
| Good morning   | 05:00 - 11:59  |
| Good afternoon | 12:00 - 17:59  |
| Good evening   | 18:00 - 20:59  |
| Good night     | 21:00 - 04:59  |

Implementation details:
- Modified `HelloController.kt` by adding the following helper method.
    ``` kotlin
        private fun getTimeGreeting(): String {
            val time = LocalTime.now().hour
            return when (time) {
                in 5..11 -> "Good morning"
                in 12..17 -> "Good afternoon"
                in 18..20 -> "Good evening"
                else -> "Good night"
            }
        }
    ```
- Created tests to verify the right greeting message is returned. 


### Theme customisation
This feature allows users to customise the theme of the page (dark/light mode). <br>
Changes made:
- Edited `styles.css`
  - Defined a colour palette for dark theme.
  - Created CSS variables that change colours depending on the selected theme.
- Edited `welcome.html`
  - Added a toggle button that allows users change from light to dark mode.
  - Removed some Bootstrap commands that defined the design of some classes.
- Created `theme.js` in order to change themes when the user clicks the toggle button and manages the storage of user's
  theme choice in localStorage.

### User preferences
This feature stores user preferences in local storage. <br>
Changes made:
- Modified `http-debug.js`:
  - In the `testApiBtn` event listener, added the following line to save the user's name.
      ``` js
          //Save name in Local Storage
          localStorage.setItem("name", name)
      ```
- Modified `theme.js`:
  - In the `themeBtn` event listener, added logic to save the theme selection.
    ``` js
        // Save preference after clicking the theme button.
        if (document.body.classList.contains("darkmode")) {
            localStorage.setItem("theme", "dark");    // Save new theme
        } else {
            localStorage.setItem("theme", "light");   // Save new theme
        }
    ```

### Multi-language support
Allow users to choose their preferred language (English, Spanish, French) by using a selector. <br>
Changes made:
- Added message files (`messages.properties`, `messages_en.properties`,`messages_es.properties`,
  `messages_fr.properties`). These files contain the necessary translation sentences in English, Spanish, and French.
- Updated `welcome.html`
  - Replaced hardcoded text with messages lookups. The following line is an example of how I have used those message lookups.
      ``` html
          <h1 th:text="#{app.title}"></h1>
      ```
  - Added a language selector in the navbar that helps users change languages easily.
- Created `i18nConfig.kt`. This file manages how the application changes when the user changes languages in the 
  language selector. Configured i18n with default locale en, and created a LocaleChangeInterceptor to listen for
  `?lang=...` changes.
- Modified `application.properties` to declare where the messages are and what encoding the app uses.
  ``` properties
    # Base name for messages' language
    spring.messages.basename=i18n/messages
    spring.messages.encoding=UTF-8
  ```
- Created tests to verify if the translation is loaded correctly.

******

## Technical Decisions
In this section there is an explanation of technical choices made.
### User preferences
Benefits of storing user preferences in local storage:
- Data remains even after the browser is closed.
- Simple API for storing and accessing data.
- Works for the same source across several tabs in the browser.

### Theme customisation
- Using CSS variables instead of hardcoded styles makes the theme maintenance much easier.

### Multi-language
- Message lookups (`th:text="#{...}"`) simplifies future updates, and makes it easier in case a new language is added.
- The use of `LocaleChangeInterceptor` allows users to change languages dynamically, without having to restart the session.


******

## Learning Outcomes
This section includes the things I have learned from this assignment.<br>

- Some features may sound easy, but in reality they are the most tricky ones. 
  - During this assignment, I have changed my mind about the features to implement a lot of times. This is 
    because I underestimated the time some of them may take. For example, it happened with the multi-language feature.
- Learned how Spring Boot internationalisation works.
  - I didn't know i18n before, and I learned how internationalisation works, including message resource handling 
    and locale switching. 
- Understand how testing works.
  - As I went on an Erasmus last year, I didn't have the opportunity to study "Verification and Validation" subject,
    so before this subject I had never done a test for an application. Through this assignment, I have come to 
    understand a little bit better how testing works.
******

## AI Disclosure
This section contains a list of the specific AI tools used in the assignment, 
along with what has been generated with AI assistance, and the work done without it.
### AI Tools Used
- DeepSeek: brainstorming implementation approaches.
- ChatGPT: explanations, debugging help, and translations.
- Grammarly: grammar corrections and improving the clarity of the report.

### AI-Assisted Work
**GENERAL MATTERS**
- Generate an ordered list of the functionality, based on their difficulty. This helped me decide which functionalities
I wanted to implement first.
- Rewrite some of the explanations, in order to increase its clarity.
- Explanations on how to do tests.

**THEME CUSTOMISATION**
- Debugging small issues (e.g. fixing path errors).

**MULTI-LANGUAGE SUPPORT**
- Explanation of i18n and how to implement it.
- Assistance with resolving installation/configuration errors.
- Translated content into French for the `messages_fr.properties` file.


### Original Work
The majority of this project has been coded and implemented by myself.
- Base code was provided by the teacher
- AI was used as an assistant for clarification, translations, and debugging (mentioned in the previous section)
- Additional coding tips were researched through Internet (see Bibliography).

******

## Bibliography
- Markdown guide in order to understand how its syntax works.
    - https://www.markdownguide.org/
- How to use Local Storage in JavaScript
    - https://staticmania.com/blog/how-to-use-local-storage-in-javascript
- Use of variables in CSS
  - https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_cascading_variables/Using_CSS_custom_properties
- How to toggle dark mode
  - https://www.w3schools.com/howto/howto_js_toggle_dark_mode.asp
- Discussions with classmates about implementation approaches.

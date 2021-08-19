## Task 2

### 1. Create a REST service that accepts string “title” as input

### 2. Send request to a REST service for XML (important to use XML here, no cheating with Json directly). Here is an example for a query for “lost”: http://www.omdbapi.com/?t=lost&r=xml&apikey=<API key>. You can use any other open REST service if it provides an XML output. If you do, please provide instructions for the configuration (if API keys are required, etc.)
### 3. Transform XML to a JSON and return the data


### The following two I've ignored this time :-)
#### 4. If you use a library or a framework, provide explanation why it is needed. Try to minimize the use of libraries.
#### 5. Pretend that this service is something that will be delivered to customers and should be maintained for many years, think about good code structure and documentation

## Setup
Clone the repository and either in your system or favorite IDE set up the following env variables:
```
API_KEY
XML_API_URI
```
## Running
Using your favorite IDE run:
```
.src/main/java/com/movie/api/MovieApplication.java
```
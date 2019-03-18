# Into TW.

## Intro

Thanks for taking the time to have a conversation with us.

This is a take-home technical test designed to be fun and allow you to show a little creativity.

It is based on real code that we have implemented more than once.

You should feel free to contact us to ask questions, pop in for a chat to mull over ideas, sit and work at a desk if you like, we're here to help (to a degree!). There is no time-limit on this challenge, take as long or as little as you like.

Once you are ready, reply to the email you received and come to our offices for a chat about your solution.

## Details

You will likely want to install Leiningen, once installed you can run 'lein test' in the root directory to run tests.

Use whatever IDE you like, at TW we use all of them. If you're new to Clojure Intellij+Cursive might be easiest.

There are three files:

1. [operativ.kafka.topic.clj](src/operativ/kafka/topic.clj) contains two functions that we would like you to implement
2. [operativ.kafka.topic-test.clj](test/operativ/kafka/topic_test.clj)  contains three tests that currently fail
3. [operativ.test.data.cljc](test/operativ/test/data.clj) contains the test data and description of what it all means

There are is one principal technical challenge:

1. Implement the operativ.kafka.topic/sizes function, causing the first test to pass.

There is an extension technical challenge:

2. Implement the remaining functions, causing all the tests to pass.

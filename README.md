# clj-twilio

Clojure Twilio API

Add this to your project.clj :dependencies list:

    [clj-twilio "0.1.0"]

## Usage

TwiML voice response:
    
    (use 'twilio.core)
    (use 'twilio.voice)
    
    (twiml-response (say "Message"))
    > "<?xml version=\"1.1\" encoding=\"UTF-8\"?><Response><Say>Message</Say></Response>"
    
    (twiml-response (say "Message")
                    (play "message.mp3"))
    > "<?xml version=\"1.1\" encoding=\"UTF-8\"?><Response><Say>Message</Say><Play>message.mp3</Play></Response>"
    
    (twiml-response (gather {:action "/process_gather.php" :method "GET"}
                            (say "Please enter your account number, followed by the pound sign"))
                    (say "We didn't receive any input. Goodbye!"))
    > "<?xml version=\"1.1\" encoding=\"UTF-8\"?><Response><Gather action=\"/process_gather.php\" method=\"GET\"><Say>Please enter your account number, followed by the pound sign</Say></Gather><Say>We didn&apos;t receive any input. Goodbye!</Say></Response>"

## The MIT License

Copyright (c) 2010 Seth Buntin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

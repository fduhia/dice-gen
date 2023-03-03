# DiceGen: Passphrase Generator

DiceGen generates strong passphrases that are easy to remember using the Diceware algorithm
and the EFF long wordlist.

![XKCD Secure Passwords](https://imgs.xkcd.com/comics/password_strength.png "Password Strength")

## How to run

[![Run on Repl.it](https://replit.com/badge/github/fduhia/dice-gen)](https://replit.com/new/github/fduhia/dice-gen)

[Clojure tools](https://clojure.org/reference/deps_and_cli) are required to run this app. You can install them from [here](https://clojure.org/guides/install_clojure)

In your terminal run the following to generate a default 6 word passphrase:

``` bash
$ clj -X cumulus.dice-gen.generator/run
```

Or you can specify the desired length:

``` bash
$ clj -x cumulus.dice-gen.generator/run :len <number of words in passphrase>

e.g

$ clj -x cumulus.dice-gen.generator/run :len 8
```

## License

Licensed under the GPLv3: http://www.gnu.org/licenses/gpl-3.0.html

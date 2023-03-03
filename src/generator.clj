(ns cumulus.dice-gen.generator
  (:require [clojure.string :as s]))

(defn load-list [file]
  (let [word-file (slurp file)
        wl (s/split-lines word-file)
        ls (for [l wl]
             (s/split l #"\t"))]
    ls))

(defn wordlist->map [file]
  (let [wl (load-list file)]
    (into {}
          (for [line wl]
            [(keyword (first line)) (second line)]))))

(def wordlist (wordlist->map "resources/eff-large-wordlist.txt"))

(defn roll-dice []
  (let [roll-values (for [roll (range 1 6)]
                      (rand-nth [1 2 3 4 5 6]))]
    (keyword (s/join roll-values))))

(defn gen-passphrase
  ([] (gen-passphrase 6))
  ([phrase-length]
   (let [ks (for [n (range phrase-length)]
              (roll-dice))
         phrases (for [k ks]
                   (k wordlist))]
     (s/join "-" phrases))))

(defn run [opts]
  (if (nil? opts)
    (println (gen-passphrase))
    (println (gen-passphrase (first opts)))))

(defn -main [opts]
  (if (nil? opts)
    (println (gen-passphrase))
    (println (gen-passphrase (first opts)))))

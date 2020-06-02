# Makefile for Scala Wechaty
#
# 	GitHb: https://github.com/wechaty/scala-wechaty-getting-started
# 	Author: Huan LI <zixia@zixia.net> github.com/huan
#

.PHONY: all
all : clean lint

.PHONY: clean
clean:
	rm -fr dist/*

.PHONY: lint
lint:
	echo lint scala

.PHONY: install
install:
	echo install scala

.PHONY: test
test:
	echo test scala

.PHONY: bot
bot:
	scala examples/ding-dong-bot.scala

.PHONY: version
version:
	@newVersion=$$(awk -F. '{print $$1"."$$2"."$$3+1}' < VERSION) \
		&& echo $${newVersion} > VERSION \
		&& git add VERSION \
		&& git commit -m "$${newVersion}" > /dev/null \
		&& git tag "v$${newVersion}" \
		&& echo "Bumped version to $${newVersion}"

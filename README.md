# Telegram Game Bot

## Your mission 🚀
- Develop a telegram chat-bot 
- The bot should be able to play some kind of game with you (see [below](#ideas-for-chat-based-games--friendly-supported-by-chatgpt-) for ideas)
- Understand the structure of the [Telegram Bot API](https://core.telegram.org/bots)
- create a useful OOP based structure of your Java project
- present your Bot within 6-9 minutes (ideally: let visitors try your bot themselves)
- think about nice extensions of the basic Bot API (like multiplayer mode)
- host your code on Github, apply the basic rules for the use of Git:
  - small & frequent commits
  - branches whenever useful

## Getting started with the Telegram Bot API 🤖
1. You'll need a Telegram account
2. To create a new bot, you will have to contact [@BotFather](https://core.telegram.org/bots/features#botfather) to obtain a string token which is required to authorize the bot.

## Screen the example project 🔎
**Disclaimer**: The provided example is just a rough sketch of what is easily doable with the Telegram Bot API. There is
neither a guarantee for a "good" design approach nor for the correct usage of the API. 
1. get familiar with the `pom.xml` (and Maven) first to understand how your dependencies are set up.
2. walk through the java-files in the following order:
   1. `Main.java`
   2. `Bot.java`
   3. `Question.java`
   4. `Quiz.java`

## Ideas for chat-based games (friendly supported by chatGPT) 💡
1. Mystery Detective: Players take on the role of detectives and engage in a conversation with an AI-controlled suspect. They must ask questions, gather clues, and make deductions to solve a mysterious crime.
2. Storytelling Adventure: Players participate in an interactive storytelling adventure where they make choices through chat commands. The AI responds to their commands and progresses the story based on their decisions, leading to different outcomes and endings.
3. Trivia Challenge: The AI presents players with trivia questions in various categories, and they respond with their answers through chat. The AI keeps track of scores and provides feedback on correct and incorrect answers.
4. Role-Playing Game (RPG): Players create their characters and embark on an epic quest through a chat-based RPG. They engage in dialogue with non-player characters, make decisions, and engage in combat encounters, all through chat commands.
5. Word Puzzles: The AI presents players with word puzzles, such as anagrams, riddles, or word associations. Players try to solve the puzzles by providing their answers through chat, and the AI provides feedback on their correctness.
6. Personality Test: The AI presents a series of questions to players, aiming to assess their personalities. Based on their responses, the AI generates a personalized profile or offers insights into their character traits.
7. Virtual Pet: Players adopt a virtual pet that exists entirely within the chat interface. They can interact with the pet through chat commands, feed it, play with it, and take care of its needs.
8. You don't know Jack: My personal favourite quiz game! Check-out the [JS-based demo](https://de.ydkj.eu/)


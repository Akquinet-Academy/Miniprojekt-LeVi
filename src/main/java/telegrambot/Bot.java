package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.codeconundrum.Case;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {
    boolean ongoing = true;
    private InlineKeyboardMarkup mainMenu;
    private InlineKeyboardMarkup suspectMenu;
    private InlineKeyboardMarkup questionsMenu;
    private InlineKeyboardMarkup placesMenu;
    private InlineKeyboardMarkup desksMenu;
    private InlineKeyboardMarkup accuseSuspectsMenu;
    Case gitHubChaos;

    @Override
    public void onUpdateReceived(Update update) {
        //Message.enableHtml
        long chatId = getChatId(update);
        String messageReceived = getMessage(update);
        System.out.println(messageReceived);
        gitHubChaos = new Case();

        // start to evaluate the messages you received
        // 1. Main menu
        if (messageReceived.toLowerCase().startsWith("/start")) {
            sendResponse(chatId, "Quick, detective, we've got a Code Conundrum! \uD83D\uDD75\uFE0F");
            sendResponse(chatId, "Critical GitHub branches vanished, possibly due to a phishing email. You must investigate in the IT department and interrogate 5 suspects.");
            sendResponse(chatId, "<b>Larry Lint</b>: Careless developer.\n\n" +
                    "<b>Rita Codecrunch</b>: Puzzle lover who leaves riddles.\n\n" +
                    "<b>Hubert Norton</b>: Meticulous IT character.\n\n" +
                    "<b>Sam Phishmaster</b>: Social engineering expert.\n\n" +
                    "<b>Maggie Clickson</b>: Click-happy internet enthusiast.");
            sendResponse(chatId, "Search these locations for clues:\n" +
                    "\n" +
                    "<b>Desks</b>: Larry's chaos, Rita's riddles, Hubert's secrecy, Sam's deception, and Maggie's internet finds.\n\n" +
                    "<b>Server Room</b>: The heart of the digital mystery.\n\n" +
                    "<b>Cafeteria</b>: Where secrets might slip during coffee breaks.");
            sendResponse(chatId, "Get ready to crack the case, detective, and save the project! The fate of the code is in your hands.");
        }
        createButtons();
        //while (ongoing) {
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            switch (callbackData) {
                case "suspect" -> sendMenu(suspectMenu, chatId);
                case "place" -> sendMenu(placesMenu, chatId);
                case "accusation" -> checkAccusation(chatId);
                case "larry" -> sendResponse(chatId, gitHubChaos.getSuspects().get("Larry").toString());
                case "rita" -> sendResponse(chatId, gitHubChaos.getSuspects().get("Rita").toString());
                case "sam" -> sendResponse(chatId, gitHubChaos.getSuspects().get("Sam").toString());
                case "maggie" -> sendResponse(chatId, gitHubChaos.getSuspects().get("Maggie").toString());
                case "hubert" -> sendResponse(chatId, gitHubChaos.getSuspects().get("Hubert").toString());
                case "desks" -> sendMenu(desksMenu, chatId);
                case "cafeteria" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Cafeteria").toString());
                case "serverRoom" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Server Room").toString());
                case "larrysDesk" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Larry's desk").toString());
                case "ritasDesk" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Rita's desk").toString());
                case "samsDesk" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Sam's desk").toString());
                case "maggiesDesk" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Maggie's desk").toString());
                case "hubertsDesk" -> sendResponse(chatId, gitHubChaos.getPlaces().get("Hubert's desk").toString());
                case "accuseWrong" -> sendResponse(chatId, "Wrong! The culprit got away and the branches are lost forever \uD83D\uDE14");
                case "accusehubert" -> sendResponse(chatId, sendConfession());
            }
        } else {
            sendMenu(mainMenu, chatId);
        }
        // }
        //ongoing = false;

    }

    private String sendConfession() {
        return "\uD83C\uDF89<b>Congratulations, detective!</b>\uD83C\uDF89\n\nHubert breaks down:\n\n\"It all started with a clumsy mistake on my part, a critical code change I couldn't admit to. To protect my reputation, I resorted to a dangerous deception. I erased the GitHub branches and staged a phishing attack from the server room, hoping to shift blame away from me. But I didn't account for such a capable detective.\"";
    }


    private long getChatId(Update update) {
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChat().getId();
        }
        return update.getMessage().getChatId();
    }

    private String getMessage(Update update) {
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getData();//.getMessage();
        }
        return update.getMessage().getText();//sendErrorMessage(chatId);
        //update.getMessage()//.getText();
    }


    void checkAccusation(long chatId) {
        sendResponse(chatId, "<b>Present your solution: </b>");
        sendResponse(chatId, "Who is the culprit?");
        sendMenu(accuseSuspectsMenu, chatId);




    gitHubChaos.getSolution();
        /*solution.put("Culprit", "Hubert");
        solution.put("Motive", "Annoyance");
        solution.put("Place", "Server Room");*/

        //ongoing = false;
    }

    private void sendMenu(InlineKeyboardMarkup keyboard, long chatId) {
        SendMessage sm = SendMessage.builder().text("What do you want to do? Choose from these options:").chatId(chatId)
                .replyMarkup(keyboard).build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void createButtons() {
        //Main menu
        InlineKeyboardButton suspect = InlineKeyboardButton.builder().text("Interrogate a suspect").callbackData("suspect").build();
        InlineKeyboardButton place = InlineKeyboardButton.builder().text("Investigate a location").callbackData("place").build();
        InlineKeyboardButton accusation = InlineKeyboardButton.builder().text("Make an accusation and end the game").callbackData("accusation").build();
        mainMenu = InlineKeyboardMarkup.builder().keyboardRow(List.of(suspect, place)).keyboardRow(List.of(accusation)).build();

        //Menü suspects
        InlineKeyboardButton larry = createKeyboardButton("Larry", "larry");
        InlineKeyboardButton rita = InlineKeyboardButton.builder().text("Rita").callbackData("rita").build();
        InlineKeyboardButton sam = InlineKeyboardButton.builder().text("Sam").callbackData("sam").build();
        InlineKeyboardButton maggie = InlineKeyboardButton.builder().text("Maggie").callbackData("maggie").build();
        InlineKeyboardButton hubert = InlineKeyboardButton.builder().text("Hubert").callbackData("hubert").build();
        //InlineKeyboardButton back = InlineKeyboardButton.builder().text("<<").callbackData("back").build();
        suspectMenu = InlineKeyboardMarkup.builder().keyboardRow(List.of(larry, rita, hubert, sam, maggie)).build();

        //Menü questions
        InlineKeyboardButton role = createKeyboardButton("Tell me about your role in the project", "role");
        InlineKeyboardButton suspicion = createKeyboardButton("Did you notice anyone acting suspiciously?", "suspicion");
        questionsMenu = InlineKeyboardMarkup.builder().keyboardRow(List.of(role)).keyboardRow(List.of(suspicion)).build();

        //Menü places
        InlineKeyboardButton serverRoom = InlineKeyboardButton.builder().text("Investigate Server Room").callbackData("serverRoom").build();
        InlineKeyboardButton cafeteria = InlineKeyboardButton.builder().text("Investigate Cafeteria").callbackData("cafeteria").build();
        InlineKeyboardButton desks = InlineKeyboardButton.builder().text("Investigate desks").callbackData("desks").build();
        placesMenu = InlineKeyboardMarkup.builder().keyboardRow(List.of(serverRoom)).keyboardRow(List.of(cafeteria)).keyboardRow(List.of(desks)).build();

        //Menü desks
        InlineKeyboardButton larrysDesk = InlineKeyboardButton.builder().text("Investigate Larry's desk").callbackData("larrysDesk").build();
        InlineKeyboardButton ritasDesk = InlineKeyboardButton.builder().text("Investigate Rita's desk").callbackData("ritasDesk").build();
        InlineKeyboardButton samsDesk = InlineKeyboardButton.builder().text("Investigate Sam's desk").callbackData("samsDesk").build();
        InlineKeyboardButton maggiesDesk = InlineKeyboardButton.builder().text("Investigate Maggie's desk").callbackData("maggiesDesk").build();
        InlineKeyboardButton hubertsDesk = InlineKeyboardButton.builder().text("Investigate Hubert's desk").callbackData("hubertsDesk").build();
        desksMenu = InlineKeyboardMarkup.builder().keyboardRow(List.of(larrysDesk)).keyboardRow(List.of(ritasDesk)).keyboardRow(List.of(hubertsDesk)).keyboardRow(List.of(samsDesk)).keyboardRow(List.of(maggiesDesk)).build();

        //Menu AccusationSuspects
        InlineKeyboardButton suslarry = createKeyboardButton("Larry", "accuseWrong");
        InlineKeyboardButton susrita = InlineKeyboardButton.builder().text("Rita").callbackData("accuseWrong").build();
        InlineKeyboardButton sussam = InlineKeyboardButton.builder().text("Sam").callbackData("accuseWrong").build();
        InlineKeyboardButton susmaggie = InlineKeyboardButton.builder().text("Maggie").callbackData("accuseWrong").build();
        InlineKeyboardButton sushubert = InlineKeyboardButton.builder().text("Hubert").callbackData("accusehubert").build();
        accuseSuspectsMenu = InlineKeyboardMarkup.builder().keyboardRow(List.of(suslarry, susrita, sushubert, sussam, susmaggie)).build();
    }

    private static InlineKeyboardButton createKeyboardButton(String text, String callbackData) {
        return InlineKeyboardButton.builder().text(text).callbackData(callbackData).build();
    }

    private void sendResponse(long chatId, String s) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(s);
        msg.enableHtml(true);
        //msg.setParseMode("HTML");
        //msg.wait(500);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return "6650326737:AAGpegXaGjdNi7-JNPDVlo6FaoJo9hfRjbE";  // TODO: insert your bot token here!
    }

    @Override
    public String getBotUsername() {
        return "codeconundrum_bot";  // TODO: insert your bots username here
    }
}

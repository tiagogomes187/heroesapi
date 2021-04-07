package com.digitalinnovationone.heroesapi.config;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Api_Table");

        Item hero1 = new Item()
                .withPrimaryKey("id", "1")
                .withString("name", "Mulher Maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 2);

        Item hero2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        Item hero3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Capita marvel")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        Item hero4 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Homem de Ferro")
                .withString("universe", "marvel")
                .withNumber("films", 7);
        Item hero5 = new Item()

                .withPrimaryKey("id", "5")
                .withString("name", "Homem Aranha")
                .withString("universe", "marvel")
                .withNumber("films", 14);
        Item hero6 = new Item()

                .withPrimaryKey("id", "6")
                .withString("name", "Pantera Negra")
                .withString("universe", "marvel")
                .withNumber("films", 3);

        PutItemOutcome outcome1 = table.putItem(hero1);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);
        PutItemOutcome outcome4 = table.putItem(hero4);
        PutItemOutcome outcome5 = table.putItem(hero5);
        PutItemOutcome outcome6 = table.putItem(hero6);

    }
}

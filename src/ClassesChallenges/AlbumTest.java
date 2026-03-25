package ClassesChallenges;

import JmbUtils.FieldAwareInputValidator;
import JmbUtils.InputValidator;

public class AlbumTest {
    public static void RunTest() {
        while (true) {
            var albumName = InputValidator.GetString("Enter the album name: ");
            var artistsName = InputValidator.GetString("Enter the artists name: ");
            var albumPrice = InputValidator.GetDouble("Enter the price of the album: ");
            var albumStock = InputValidator.GetInt("Enter how much stock there is of this album: ");

            try {
                Album newAlbum = new Album(artistsName, albumName, albumPrice, albumStock);
                System.out.println("Your new album: ");
                newAlbum.printDetails();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void RunTestExtended() {
        /*Album newAlbum = InputValidator.GetValidObject(() -> new Album(
                InputValidator.GetString("Enter the artists name: "),
                InputValidator.GetString("Enter the album name: "),
                InputValidator.GetDouble("Enter the price of the album: "),
                InputValidator.GetInt("Enter how much stock there is: ")
        ));

        System.out.println("Your new album: ");
        newAlbum.printDetails();*/

        /*Album album = new Album();
        FieldAwareInputValidator.GetValidated(
                FieldAwareInputValidator::GetNonEmptyString,
                album::setArtist);*/

        Album album = new Album();
        InputValidator.GetValidated(
                () -> InputValidator.GetString("Enter artists name"),
                album::setArtist);

        InputValidator.GetValidated(
                () -> InputValidator.GetString("Enter albums name"),
                album::setName);

        InputValidator.GetValidated(
                () -> InputValidator.GetDouble("Enter the price of the album"),
                album::setPrice);

        InputValidator.GetValidated(
                () -> InputValidator.GetInt("How much stock is there of the album?"),
                album::setStockQuantity);
    }
}

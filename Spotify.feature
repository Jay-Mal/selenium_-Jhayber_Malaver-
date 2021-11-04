Feature: Spotify Test

  Scenario Outline: Validate the user is able to find <planName> Spotify plan
    Given the user is at Spotify homepage
    When the user clicks on Premium Section
    Then the user should see a plan "<planName>" available

    Examples:
      | planName   |
      | Individual |
      | Premium    |
      | Familiar   |

  Scenario Outline: Validate on signup section that different <email> display different <error>
    Given the user is at Spotify homepage
    When the user clicks on Registration section
    Then the user should be on the registration page
    When the user clicks on the email field
    And the user fills the "<email>" field
    And the user clicks on the confirmation field
    Then the user should see an "<error>" message

    Examples:
      | email         | error                                                                                                |
      |               | Es necesario que introduzcas tu correo electrónico.                                                  |
      | ffff          | Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com |
      | test@test.com | Este correo electrónico ya está conectado a una cuenta.                                              |

  Scenario Outline: Validate that the end user agreement page contains different <sections>
    Given the user is at Spotify homepage
    When the user navigates to the page "https://www.spotify.com/uy/legal/end-user-agreement/"
    Then the user should be on the en user agreement page
    And the user should see the following "<section>"

    Examples:
      | section                                     |
      | Disfrutando Spotify                         |
      | Pagos, cancelaciones y periodo de reflexión |
      | Uso de nuestro servicio                     |


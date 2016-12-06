package dk.sunepoulsen.stm.cli;

import dk.sunepoulsen.clt.cli.CliApplication;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import static dk.sunepoulsen.clt.cli.CliApplication.OUTPUT_LOGGER_NAME;

/**
 * Created by sunepoulsen on 06/12/2016.
 */
public class Application {
    //-------------------------------------------------------------------------
    //              Main function
    //-------------------------------------------------------------------------

    public static void main( String[] args ) {
        logger.entry( args );

        try {
            ResourceBundle bundle = ResourceBundle.getBundle( Application.class.getName().toLowerCase(), Locale.getDefault() );

            String helpText = bundle.getString( "program.help.text" );

            CliApplication app = new CliApplication( helpText, Application.class.getPackage().getName() );
            app.main( args );

            System.exit( 0 );
        }
        catch( IllegalAccessException | InstantiationException ex ) {
            output.error( ex.getMessage() );
            logger.catching( ex );

            System.exit( -1 );
        }
        finally {
            logger.exit();
        }
    }

    //-------------------------------------------------------------------------
    //              Members
    //-------------------------------------------------------------------------

    private static final XLogger logger = XLoggerFactory.getXLogger( Application.class );
    private static final XLogger output = XLoggerFactory.getXLogger( OUTPUT_LOGGER_NAME );
}

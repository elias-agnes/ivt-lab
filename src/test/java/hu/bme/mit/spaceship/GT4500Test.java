package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockTS1; 
  private TorpedoStore mockTS2; 


  @BeforeEach
  public void init(){
    mockTS1 = mock(TorpedoStore.class); 
    mockTS2 = mock(TorpedoStore.class); 
    this.ship = new GT4500(mockTS1, mockTS2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
        
    when(mockTS1.isEmpty()).thenReturn(false); 


    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert

    verify(mockTS1, times(1)).fire(1); 

  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTS1.getTorpedoCount()).thenReturn(100);
    when(mockTS2.getTorpedoCount()).thenReturn(100); 

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
    
  }

}

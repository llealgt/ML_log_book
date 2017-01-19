# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import numpy as np

class BinaryClassificationMetricCalculator:
    
    def __init__(self,predictions,real_values):
        self.predictions = predictions
        self.real_values = real_values
        
        
    def get_confusion_matrix(self):
        true_positives =  np.sum( np.logical_and((self.predictions == 1),(self.real_values == 1)))
        false_positives = np.sum(np.logical_and((self.predictions == 1),(self.real_values == 0)))
        false_negatives = np.sum(np.logical_and((self.predictions == 0),(self.real_values == 1)))
        true_negatives =  np.sum(np.logical_and((self.predictions == 0),(self.real_values == 0)))
        
        return true_positives,false_positives,true_negatives,false_negatives
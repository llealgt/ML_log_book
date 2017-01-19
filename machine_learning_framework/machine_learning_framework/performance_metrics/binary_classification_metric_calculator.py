# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import numpy as np

#Class used to calculate all performance metrics of a binary classification
#it its created with 2 parameters,numpy arrays with the predictions and the real values(numeric,0,1)
class BinaryClassificationMetricCalculator:
    
    def __init__(self,predictions,real_values):
        
        self.predictions = predictions
        self.real_values = real_values
        
        self.number_of_elements = predictions.size
        #TODO: define and code what to do if empty arrays, or arrays with different sizes are sent 
        
        self.true_positives =  np.sum(np.logical_and((self.predictions == 1),(self.real_values == 1)))
        self.false_positives = np.sum(np.logical_and((self.predictions == 1),(self.real_values == 0)))
        self.false_negatives = np.sum(np.logical_and((self.predictions == 0),(self.real_values == 1)))
        self.true_negatives =  np.sum(np.logical_and((self.predictions == 0),(self.real_values == 0)))
        
        self.right_predictions = self.true_positives  + self.true_negatives
        self.wrong_predictions = self.false_negatives + self.false_positives
        
        if (self.true_positives + self.false_positives) != 0:
            self.precision = float(self.true_positives) / (self.true_positives + self.false_positives)
        else:
             self.precision = 0
             
        if(self.true_positives + self.false_negatives):
            self.recall =    float(self.true_positives) / (self.true_positives + self.false_negatives)
        else:
            self.recall = 0
        
        if (self.precision + self.recall ) != 0:
            self.f1_score = float(2 * self.precision * self.recall) /(self.precision + self.recall )
        else:
            self.f1_score = 0
        
        if self.number_of_elements != 0:
            self.accuracy_rate = float(self.right_predictions)/self.number_of_elements
            self.misclassification_rate = float(self.wrong_predictions)/self.number_of_elements
        else:
            self.accuracy_rate = 0
            self.misclassification_rate = 0
            
            
    #get the confusion matrix in a single call
    def get_confusion_matrix(self):
        return self.true_positives,self.false_positives,self.true_negatives,self.false_negatives
    
    #TODO:create additional functions like a function to get all metrics in a single call
        